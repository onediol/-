/**
 * Базовый класс для всех типов самолетов.
 * Содержит общие характеристики и методы для всех самолетов.
 */
public abstract class Aircraft {
    private final String flightNumber;
    private int passengerCount;
    private double fuelAmount;
    private final double fuelConsumptionRate;

    /**
     * Конструктор базового класса Aircraft.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param fuelConsumptionRate расход топлива
     */
    public Aircraft(String flightNumber, int passengerCount, double fuelAmount, double fuelConsumptionRate) {
        this.flightNumber = flightNumber;
        this.passengerCount = passengerCount;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    /**
     * Рассчитывает расход топлива на основе пройденного расстояния.
     *
     * @param distance расстояние в километрах
     * @return расход топлива
     */
    public double calculateFuelConsumption(double distance) {
        return distance * fuelConsumptionRate;
    }

    /**
     * Рассчитывает максимальную дальность полета.
     *
     * @return максимальная дальность в километрах
     */
    public double calculateMaxRange() {
        return fuelAmount / fuelConsumptionRate;
    }

    // Геттеры
    public String getFlightNumber() {
        return flightNumber;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    // Сеттеры
    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    /**
     * Возвращает строковое представление объекта Aircraft.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return String.format("Рейс: %s, Пассажиры: %d, Топливо: %.2f л, Расход: %.2f л/км",
                flightNumber, passengerCount, fuelAmount, fuelConsumptionRate);
    }
}