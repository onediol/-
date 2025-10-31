public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallTime;
    private double longDistanceCallTime;

    public Phone(int id, String lastName, String firstName, String middleName, 
                String address, String creditCardNumber, double debit, double credit,
                double localCallTime, double longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallTime = localCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    // Геттеры
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getAddress() { return address; }
    public String getCreditCardNumber() { return creditCardNumber; }
    public double getDebit() { return debit; }
    public double getCredit() { return credit; }
    public double getLocalCallTime() { return localCallTime; }
    public double getLongDistanceCallTime() { return longDistanceCallTime; }

    // Сеттеры
    public void setId(int id) { this.id = id; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setAddress(String address) { this.address = address; }
    public void setCreditCardNumber(String creditCardNumber) { this.creditCardNumber = creditCardNumber; }
    public void setDebit(double debit) { this.debit = debit; }
    public void setCredit(double credit) { this.credit = credit; }
    public void setLocalCallTime(double localCallTime) { this.localCallTime = localCallTime; }
    public void setLongDistanceCallTime(double longDistanceCallTime) { this.longDistanceCallTime = longDistanceCallTime; }

    @Override
    public String toString() {
        return String.format(
            "%-3d %-12s %-12s %-12s %-20s %-19s %8.2f %8.2f %6.1f мин %6.1f мин",
            id, lastName, firstName, middleName, address, 
            creditCardNumber, debit, credit, localCallTime, longDistanceCallTime
        );
    }
}