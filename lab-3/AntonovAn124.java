/**
 * Класс Antonov An-124 - грузовой самолет.
 */
public class AntonovAn124 extends CargoAircraft {
    private static final double DEFAULT_FUEL_CONSUMPTION = 0.045;

    /**
     * Конструктор Antonov An-124.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param cargoWeight вес груза
     */
    public AntonovAn124(String flightNumber, int passengerCount, double fuelAmount, double cargoWeight) {
        super(flightNumber, passengerCount, fuelAmount, DEFAULT_FUEL_CONSUMPTION, cargoWeight);
    }

    /**
     * Возвращает строковое представление объекта AntonovAn124.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Antonov An-124: " + super.toString();
    }
}