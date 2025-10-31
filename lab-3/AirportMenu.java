import java.util.Scanner;
import java.util.List;

/**
 * Консольное меню для управления аэропортом
 */
public class AirportMenu {
    private Airport airport;
    private Scanner scanner;
    
    public AirportMenu() {
        this.airport = new Airport("Международный аэропорт");
        this.scanner = new Scanner(System.in);
        // Добавляем несколько самолетов для демонстрации
        initializeDemoData();
    }
    
    /**
     * Инициализация демонстрационных данных
     */
    private void initializeDemoData() {
        airport.addAircraft(new Boeing737("SU-1001", 180, 25000, "Эконом"));
        airport.addAircraft(new AirbusA320("SU-1002", 150, 22000, "Бизнес"));
        airport.addAircraft(new AntonovAn124("SU-1003", 6, 45000, 120000));
    }
    
    /**
     * Главное меню
     */
    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== СИСТЕМА УПРАВЛЕНИЯ АЭРОПОРТОМ ===");
            System.out.println("1. Показать все самолеты");
            System.out.println("2. Добавить самолет");
            System.out.println("3. Удалить самолет");
            System.out.println("4. Найти самолет по номеру рейса");
            System.out.println("5. Рассчитать расход топлива");
            System.out.println("6. Информация о конкретном самолете");
            System.out.println("7. Общая статистика");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    showAllAircraft();
                    break;
                case 2:
                    addAircraftMenu();
                    break;
                case 3:
                    removeAircraftMenu();
                    break;
                case 4:
                    findAircraftMenu();
                    break;
                case 5:
                    calculateFuelMenu();
                    break;
                case 6:
                    showAircraftDetails();
                    break;
                case 7:
                    showStatistics();
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }
    
    /**
     * Показать все самолеты
     */
    private void showAllAircraft() {
        System.out.println("\n=== ВСЕ САМОЛЕТЫ В АЭРОПОРТУ ===");
        airport.displayAllAircraft();
    }
    
    /**
     * Меню добавления самолета
     */
    private void addAircraftMenu() {
        System.out.println("\n=== ДОБАВЛЕНИЕ НОВОГО САМОЛЕТА ===");
        System.out.println("1. Boeing 737 (пассажирский)");
        System.out.println("2. Airbus A320 (пассажирский)");
        System.out.println("3. Antonov An-124 (грузовой)");
        System.out.print("Выберите тип самолета: ");
        
        int typeChoice = getIntInput();
        
        System.out.print("Введите номер рейса: ");
        String flightNumber = scanner.nextLine();
        
        System.out.print("Введите количество пассажиров: ");
        int passengers = getIntInput();
        
        System.out.print("Введите количество топлива (л): ");
        double fuel = getDoubleInput();
        
        Aircraft newAircraft = null;
        
        switch (typeChoice) {
            case 1:
                System.out.print("Введите класс обслуживания: ");
                String seatClass1 = scanner.nextLine();
                newAircraft = new Boeing737(flightNumber, passengers, fuel, seatClass1);
                break;
            case 2:
                System.out.print("Введите класс обслуживания: ");
                String seatClass2 = scanner.nextLine();
                newAircraft = new AirbusA320(flightNumber, passengers, fuel, seatClass2);
                break;
            case 3:
                System.out.print("Введите вес груза (кг): ");
                double cargoWeight = getDoubleInput();
                newAircraft = new AntonovAn124(flightNumber, passengers, fuel, cargoWeight);
                break;
            default:
                System.out.println("Неверный выбор типа самолета!");
                return;
        }
        
        if (newAircraft != null) {
            airport.addAircraft(newAircraft);
            System.out.println("Самолет успешно добавлен!");
        }
    }
    
    /**
     * Меню удаления самолета
     */
    private void removeAircraftMenu() {
        System.out.println("\n=== УДАЛЕНИЕ САМОЛЕТА ===");
        System.out.print("Введите номер рейса для удаления: ");
        String flightNumber = scanner.nextLine();
        
        boolean removed = airport.removeAircraft(flightNumber);
        if (removed) {
            System.out.println("Самолет с номером " + flightNumber + " успешно удален!");
        } else {
            System.out.println("Самолет с номером " + flightNumber + " не найден!");
        }
    }
    
    /**
     * Меню поиска самолета
     */
    private void findAircraftMenu() {
        System.out.println("\n=== ПОИСК САМОЛЕТА ===");
        System.out.print("Введите номер рейса: ");
        String flightNumber = scanner.nextLine();
        
        Aircraft aircraft = airport.findAircraft(flightNumber);
        if (aircraft != null) {
            System.out.println("Найден самолет:");
            System.out.println(aircraft);
            
            // Дополнительная информация в зависимости от типа
            if (aircraft instanceof PassengerAircraft) {
                PassengerAircraft pa = (PassengerAircraft) aircraft;
                System.out.println("Класс обслуживания: " + pa.getSeatClass());
            } else if (aircraft instanceof CargoAircraft) {
                CargoAircraft ca = (CargoAircraft) aircraft;
                System.out.println("Вес груза: " + ca.getCargoWeight() + " кг");
            }
        } else {
            System.out.println("Самолет с номером " + flightNumber + " не найден!");
        }
    }
    
    /**
     * Меню расчета расхода топлива
     */
    private void calculateFuelMenu() {
        System.out.println("\n=== РАСЧЕТ РАСХОДА ТОПЛИВА ===");
        System.out.print("Введите расстояние (км): ");
        double distance = getDoubleInput();
        
        System.out.println("\nРезультаты расчета:");
        System.out.println("Расстояние: " + distance + " км");
        System.out.println("----------------------------------------");
        
        List<Aircraft> aircraftList = airport.getAircraftList();
        double totalConsumption = 0;
        
        for (Aircraft aircraft : aircraftList) {
            double consumption = aircraft.calculateFuelConsumption(distance);
            double maxRange = aircraft.calculateMaxRange();
            totalConsumption += consumption;
            
            System.out.printf("%s:%n", aircraft.getFlightNumber());
            System.out.printf("  Расход топлива: %.2f л%n", consumption);
            System.out.printf("  Макс. дальность: %.2f км%n", maxRange);
            System.out.println();
        }
        
        System.out.printf("ОБЩИЙ РАСХОД ТОПЛИВА: %.2f л%n", totalConsumption);
    }
    
    /**
     * Детальная информация о самолете
     */
    private void showAircraftDetails() {
        System.out.println("\n=== ИНФОРМАЦИЯ О САМОЛЕТЕ ===");
        System.out.print("Введите номер рейса: ");
        String flightNumber = scanner.nextLine();
        
        Aircraft aircraft = airport.findAircraft(flightNumber);
        if (aircraft != null) {
            System.out.println("\nДЕТАЛЬНАЯ ИНФОРМАЦИЯ:");
            System.out.println("Тип: " + aircraft.getClass().getSimpleName());
            System.out.println("Номер рейса: " + aircraft.getFlightNumber());
            System.out.println("Количество пассажиров: " + aircraft.getPassengerCount());
            System.out.println("Топливо: " + aircraft.getFuelAmount() + " л");
            System.out.println("Расход топлива: " + aircraft.getFuelConsumptionRate() + " л/км");
            System.out.println("Макс. дальность: " + aircraft.calculateMaxRange() + " км");
            
            if (aircraft instanceof PassengerAircraft) {
                PassengerAircraft pa = (PassengerAircraft) aircraft;
                System.out.println("Класс обслуживания: " + pa.getSeatClass());
            } else if (aircraft instanceof CargoAircraft) {
                CargoAircraft ca = (CargoAircraft) aircraft;
                System.out.println("Вес груза: " + ca.getCargoWeight() + " кг");
            }
        } else {
            System.out.println("Самолет не найден!");
        }
    }
    
    /**
     * Общая статистика аэропорта
     */
    private void showStatistics() {
        System.out.println("\n=== ОБЩАЯ СТАТИСТИКА АЭРОПОРТА ===");
        List<Aircraft> aircraftList = airport.getAircraftList();
        
        int totalPassengers = 0;
        double totalFuel = 0;
        int passengerAircraftCount = 0;
        int cargoAircraftCount = 0;
        
        for (Aircraft aircraft : aircraftList) {
            totalPassengers += aircraft.getPassengerCount();
            totalFuel += aircraft.getFuelAmount();
            
            if (aircraft instanceof PassengerAircraft) {
                passengerAircraftCount++;
            } else if (aircraft instanceof CargoAircraft) {
                cargoAircraftCount++;
            }
        }
        
        System.out.println("Общее количество самолетов: " + aircraftList.size());
        System.out.println("Пассажирских самолетов: " + passengerAircraftCount);
        System.out.println("Грузовых самолетов: " + cargoAircraftCount);
        System.out.println("Общее количество пассажиров: " + totalPassengers);
        System.out.println("Общее количество топлива: " + totalFuel + " л");
        System.out.printf("Среднее количество пассажиров на самолет: %.1f%n", 
                         (double) totalPassengers / aircraftList.size());
    }
    
    /**
     * Ввод целого числа с проверкой
     */
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }
    
    /**
     * Ввод дробного числа с проверкой
     */
    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите число: ");
            }
        }
    }
    
    /**
     * Главный метод программы
     */
    public static void main(String[] args) {
        AirportMenu menu = new AirportMenu();
        menu.showMainMenu();
    }
}
