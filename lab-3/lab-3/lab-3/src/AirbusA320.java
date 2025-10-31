/**
 * Класс Airbus A320 - пассажирский самолет.
 */
public class AirbusA320 extends PassengerAircraft {
    private static final double DEFAULT_FUEL_CONSUMPTION = 0.023;

    /**
     * Конструктор Airbus A320.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param seatClass класс обслуживания
     */
    public AirbusA320(String flightNumber, int passengerCount, double fuelAmount, String seatClass) {
        super(flightNumber, passengerCount, fuelAmount, DEFAULT_FUEL_CONSUMPTION, seatClass);
    }

    /**
     * Возвращает строковое представление объекта AirbusA320.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Airbus A320: " + super.toString();
    }
}