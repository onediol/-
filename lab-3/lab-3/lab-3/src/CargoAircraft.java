/**
 * Класс грузового самолета.
 * Наследуется от базового класса Aircraft.
 */
public abstract class CargoAircraft extends Aircraft {
    private double cargoWeight;

    /**
     * Конструктор класса CargoAircraft.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param fuelConsumptionRate расход топлива
     * @param cargoWeight вес груза
     */
    public CargoAircraft(String flightNumber, int passengerCount, double fuelAmount, 
                       double fuelConsumptionRate, double cargoWeight) {
        super(flightNumber, passengerCount, fuelAmount, fuelConsumptionRate);
        this.cargoWeight = cargoWeight;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    /**
     * Рассчитывает расход топлива с учетом веса груза.
     *
     * @param distance расстояние в километрах
     * @return расход топлива
     */
    @Override
    public double calculateFuelConsumption(double distance) {
        double baseConsumption = super.calculateFuelConsumption(distance);
        // Увеличиваем расход на 1% за каждую тонну груза
        return baseConsumption * (1 + cargoWeight / 1000 * 0.01);
    }

    /**
     * Возвращает строковое представление объекта CargoAircraft.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Груз: %.2f кг", cargoWeight);
    }
}