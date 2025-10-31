/**
 * Класс Дисковод
 */
public class DiskDrive extends Component {
    private String type; // CD, DVD, Blu-ray
    
    public DiskDrive(String name, String type) {
        super(name);
        this.type = type;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Дисковод: " + name + ", Тип: " + type);
    }
    
    // Геттеры и сеттеры
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    // Переопределение стандартных методов
    @Override
    public String toString() {
        return "Дисковод{название='" + name + "', тип='" + type + "'}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DiskDrive diskDrive = (DiskDrive) obj;
        return name.equals(diskDrive.name) && type.equals(diskDrive.type);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode();
    }
}
