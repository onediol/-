/**
 * Класс пассажирского самолета.
 * Наследуется от базового класса Aircraft.
 */
public abstract class PassengerAircraft extends Aircraft {
    private String seatClass;

    /**
     * Конструктор класса PassengerAircraft.
     *
     * @param flightNumber номер рейса
     * @param passengerCount количество пассажиров
     * @param fuelAmount количество топлива
     * @param fuelConsumptionRate расход топлива
     * @param seatClass класс обслуживания
     */
    public PassengerAircraft(String flightNumber, int passengerCount, double fuelAmount, 
                           double fuelConsumptionRate, String seatClass) {
        super(flightNumber, passengerCount, fuelAmount, fuelConsumptionRate);
        this.seatClass = seatClass;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    /**
     * Возвращает строковое представление объекта PassengerAircraft.
     *
     * @return строковое представление
     */
    @Override
    public String toString() {
        return super.toString() + String.format(", Класс: %s", seatClass);
    }
}