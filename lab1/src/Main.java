public class Main {
    public static void main(String[] args) {
        Phone[] phonesArray = {
            new Phone(1, "Иванов", "Иван", "Иванович", "ул. Ленина, 1", "1234567812345678", 1000.0, 500.0, 120.5, 15.2),
            new Phone(2, "Петров", "Петр", "Петрович", "ул. Советская, 25", "8765432187654321", 1500.0, 300.0, 85.0, 0.0),
            new Phone(3, "Сидоров", "Алексей", "Николаевич", "пр. Мира, 15", "1111222233334444", 2000.0, 200.0, 200.0, 45.8),
            new Phone(4, "Кузнецов", "Дмитрий", "Сергеевич", "ул. Центральная, 10", "5555666677778888", 800.0, 400.0, 60.0, 0.0),
            new Phone(5, "Смирнов", "Андрей", "Владимирович", "ул. Школьная, 5", "9999888877776666", 1200.0, 600.0, 180.0, 32.5)
        };

        PhoneManager manager = new PhoneManager(phonesArray);

        System.out.println("ВСЕ АБОНЕНТЫ:");
        System.out.println("=".repeat(130));
        System.out.printf("%-3s %-12s %-12s %-12s %-20s %-19s %-8s %-8s %-10s %-10s%n",
            "ID", "Фамилия", "Имя", "Отчество", "Адрес", "Номер карты", 
            "Дебет", "Кредит", "Городские", "Межгород");
        System.out.println("-".repeat(130));
        for (Phone phone : phonesArray) {
            System.out.println(phone);
        }
        System.out.println("=".repeat(130));

        // Запрос a)
        Phone[] localCallsExceeding = manager.getSubscribersWithLocalCallsExceeding(100.0);
        PhoneManager.printPhones(localCallsExceeding, "Абоненты с внутригородскими разговорами > 100 минут");

        // Запрос b)
        Phone[] longDistanceUsers = manager.getSubscribersWithLongDistanceCalls();
        PhoneManager.printPhones(longDistanceUsers, "Абоненты, пользовавшиеся междугородной связью");

        // Запрос c)
        Phone[] alphabeticalOrder = manager.getSubscribersInAlphabeticalOrder();
        PhoneManager.printPhones(alphabeticalOrder, "Абоненты в алфавитном порядке");
    }
}