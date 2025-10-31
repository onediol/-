/**
 * Класс Компьютер
 */
public class Computer {
    private String name;
    private Winchester winchester;
    private DiskDrive diskDrive;
    private RAM ram;
    private boolean isPoweredOn;
    
    public Computer(String name, Winchester winchester, DiskDrive diskDrive, RAM ram) {
        this.name = name;
        this.winchester = winchester;
        this.diskDrive = diskDrive;
        this.ram = ram;
        this.isPoweredOn = false;
    }
    
    /**
     * Включить компьютер
     */
    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println("Компьютер " + name + " включен");
        } else {
            System.out.println("Компьютер " + name + " уже включен");
        }
    }
    
    /**
     * Выключить компьютер
     */
    public void powerOff() {
        if (isPoweredOn) {
            isPoweredOn = false;
            System.out.println("Компьютер " + name + " выключен");
        } else {
            System.out.println("Компьютер " + name + " уже выключен");
        }
    }
    
    /**
     * Проверить на вирусы
     */
    public void checkForViruses() {
        if (!isPoweredOn) {
            System.out.println("Сначала включите компьютер!");
            return;
        }
        
        System.out.println("Проверка компьютера " + name + " на вирусы...");
        boolean hasViruses = winchester.checkForViruses();
        
        if (hasViruses) {
            System.out.println("ВНИМАНИЕ! На винчестере обнаружены вирусы!");
        } else {
            System.out.println("Вирусы не обнаружены. Компьютер чист.");
        }
    }
    
    /**
     * Вывести размер винчестера на консоль
     */
    public void printWinchesterSize() {
        System.out.println("Размер винчестера компьютера " + name + ": " + 
                          winchester.getSize() + " ГБ");
    }
    
    /**
     * Вывести информацию о всех компонентах
     */
    public void printAllComponentsInfo() {
        System.out.println("Компоненты компьютера " + name + ":");
        winchester.printInfo();
        diskDrive.printInfo();
        ram.printInfo();
    }
    
    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Winchester getWinchester() { return winchester; }
    public DiskDrive getDiskDrive() { return diskDrive; }
    public RAM getRam() { return ram; }
    public boolean isPoweredOn() { return isPoweredOn; }
    
    // Переопределение стандартных методов
    @Override
    public String toString() {
        return "Компьютер{название='" + name + "', включен=" + isPoweredOn + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Computer computer = (Computer) obj;
        return name.equals(computer.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
