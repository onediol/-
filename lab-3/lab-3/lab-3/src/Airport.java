import java.util.ArrayList;
import java.util.List;

/**
 * Класс аэропорта для управления самолетами.
 * Использует композицию для хранения списка самолетов.
 */
public class Airport {
    private final String name;
    private final List<Aircraft> aircraftList;

    /**
     * Конструктор класса Airport.
     *
     * @param name название аэропорта
     */
    public Airport(String name) {
        this.name = name;
        this.aircraftList = new ArrayList<>();
    }

    /**
     * Добавляет самолет в аэропорт.
     *
     * @param aircraft самолет для добавления
     */
    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    /**
     * Удаляет самолет из аэропорта по номеру рейса.
     *
     * @param flightNumber номер рейса
     * @return true если удаление успешно, false в противном случае
     */
    public boolean removeAircraft(String flightNumber) {
        return aircraftList.removeIf(aircraft -> aircraft.getFlightNumber().equals(flightNumber));
    }

    /**
     * Находит самолет по номеру рейса.
     *
     * @param flightNumber номер рейса
     * @return найденный самолет или null
     */
    public Aircraft findAircraft(String flightNumber) {
        return aircraftList.stream()
                .filter(aircraft -> aircraft.getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElse(null);
    }

    /**
     * Рассчитывает общий расход топлива для всех самолетов на заданное расстояние.
     *
     * @param distance расстояние в километрах
     * @return общий расход топлива
     */
    public double calculateTotalFuelConsumption(double distance) {
        return aircraftList.stream()
                .mapToDouble(aircraft -> aircraft.calculateFuelConsumption(distance))
                .sum();
    }

    /**
     * Выводит информацию о всех самолетах в аэропорту.
     */
    public void displayAllAircraft() {
        System.out.println("Аэропорт: " + name);
        System.out.println("Количество самолетов: " + aircraftList.size());
        System.out.println("Список самолетов:");
        aircraftList.forEach(aircraft -> System.out.println("  - " + aircraft));
    }

    /**
     * Возвращает список всех самолетов.
     *
     * @return список самолетов
     */
    public List<Aircraft> getAircraftList() {
        return new ArrayList<>(aircraftList);
    }

    public String getName() {
        return name;
    }
}