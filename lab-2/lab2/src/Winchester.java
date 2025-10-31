/**
 * Класс Винчестер (жесткий диск)
 */
public class Winchester extends Component {
    private int size; // размер в ГБ
    private boolean hasViruses;
    
    public Winchester(String name, int size) {
        super(name);
        this.size = size;
        this.hasViruses = false;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Винчестер: " + name + ", Размер: " + size + " ГБ, Вирусы: " + 
                          (hasViruses ? "обнаружены" : "не обнаружены"));
    }
    
    // Проверка на вирусы
    public boolean checkForViruses() {
        // Имитация случайного обнаружения вирусов
        this.hasViruses = Math.random() > 0.7;
        return hasViruses;
    }
    
    public void cleanViruses() {
        this.hasViruses = false;
    }
    
    // Геттеры и сеттеры
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public boolean hasViruses() { return hasViruses; }
    
    // Переопределение стандартных методов
    @Override
    public String toString() {
        return "Винчестер{название='" + name + "', размер=" + size + " ГБ}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Winchester winchester = (Winchester) obj;
        return size == winchester.size && name.equals(winchester.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + Integer.hashCode(size);
    }
}
