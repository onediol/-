/**
 * Демонстрационное приложение для тестирования иерархии классов самолетов.
 */
public class AirportDemo {
    public static void main(String[] args) {
        // Создаем аэропорт
        Airport airport = new Airport("Шереметьево");

        // Создаем 3+ экземпляра самолетов
        Boeing737 boeing1 = new Boeing737("SU-1001", 180, 25000, "Эконом");
        AirbusA320 airbus1 = new AirbusA320("SU-1002", 150, 22000, "Бизнес");
        AntonovAn124 antonov1 = new AntonovAn124("SU-1003", 6, 45000, 120000);
        Boeing737 boeing2 = new Boeing737("SU-1004", 160, 24000, "Первый");

        // Добавляем самолеты в аэропорт
        airport.addAircraft(boeing1);
        airport.addAircraft(airbus1);
        airport.addAircraft(antonov1);
        airport.addAircraft(boeing2);

        // Демонстрация работы
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ СИСТЕМЫ АЭРОПОРТА ===\n");

        // Отображаем все самолеты
        airport.displayAllAircraft();

        // Демонстрация расчета расхода топлива
        System.out.println("\n=== РАСЧЕТ РАСХОДА ТОПЛИВА ===");
        double distance = 1000; // 1000 км

        for (Aircraft aircraft : airport.getAircraftList()) {
            double fuelConsumption = aircraft.calculateFuelConsumption(distance);
            double maxRange = aircraft.calculateMaxRange();
            System.out.printf("%s - Расход на %d км: %.2f л, Макс. дальность: %.2f км%n",
                    aircraft.getFlightNumber(), (int)distance, fuelConsumption, maxRange);
        }

        // Общий расход топлива
        double totalConsumption = airport.calculateTotalFuelConsumption(distance);
        System.out.printf("\nОбщий расход топлива для всех самолетов на %d км: %.2f л%n",
                (int)distance, totalConsumption);

        // Поиск самолета
        System.out.println("\n=== ПОИСК САМОЛЕТА ===");
        String searchFlight = "SU-1002";
        Aircraft foundAircraft = airport.findAircraft(searchFlight);
        if (foundAircraft != null) {
            System.out.println("Найден самолет: " + foundAircraft);
        } else {
            System.out.println("Самолет с номером " + searchFlight + " не найден");
        }

        // Удаление самолета
        System.out.println("\n=== УДАЛЕНИЕ САМОЛЕТА ===");
        boolean removed = airport.removeAircraft("SU-1001");
        System.out.println("Самолет SU-1001 " + (removed ? "удален" : "не найден"));
        
        airport.displayAllAircraft();
    }
}