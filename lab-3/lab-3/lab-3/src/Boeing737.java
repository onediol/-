public class Boeing737 extends PassengerAircraft {
    private static final double DEFAULT_FUEL_CONSUMPTION = 0.025;

    /**
     * Конструктор Boeing 737.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param seatClass класс обслуживания
     */
    public Boeing737(String flightNumber, int passengerCount, double fuelAmount, String seatClass) {
        super(flightNumber, passengerCount, fuelAmount, DEFAULT_FUEL_CONSUMPTION, seatClass);
    }

    /**
     * Возвращает строковое представление объекта Boeing737.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return "Boeing 737: " + super.toString();
    }
}