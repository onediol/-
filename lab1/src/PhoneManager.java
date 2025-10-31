import java.util.Arrays;
import java.util.Comparator;

public class PhoneManager {
    private Phone[] phones;

    public PhoneManager(Phone[] phones) {
        this.phones = phones;
    }

    public Phone[] getPhones() { return phones; }
    public void setPhones(Phone[] phones) { this.phones = phones; }

    public Phone[] getSubscribersWithLocalCallsExceeding(double threshold) {
        return Arrays.stream(phones)
                .filter(phone -> phone.getLocalCallTime() > threshold)
                .toArray(Phone[]::new);
    }

    public Phone[] getSubscribersWithLongDistanceCalls() {
        return Arrays.stream(phones)
                .filter(phone -> phone.getLongDistanceCallTime() > 0)
                .toArray(Phone[]::new);
    }

    public Phone[] getSubscribersInAlphabeticalOrder() {
        Phone[] sortedPhones = phones.clone();
        Arrays.sort(sortedPhones, Comparator.comparing(Phone::getLastName)
                .thenComparing(Phone::getFirstName)
                .thenComparing(Phone::getMiddleName));
        return sortedPhones;
    }

    public static void printPhones(Phone[] phones, String title) {
        System.out.println("\n" + title + ":");
        System.out.println("=".repeat(130));
        System.out.printf("%-3s %-12s %-12s %-12s %-20s %-19s %-8s %-8s %-10s %-10s%n",
            "ID", "Фамилия", "Имя", "Отчество", "Адрес", "Номер карты", 
            "Дебет", "Кредит", "Городские", "Межгород");
        System.out.println("-".repeat(130));
        
        for (Phone phone : phones) {
            System.out.println(phone);
        }
        
        if (phones.length == 0) {
            System.out.println("Нет данных, соответствующих критерию.");
        }
        System.out.println("=".repeat(130));
        System.out.println("Найдено записей: " + phones.length);
    }
}
