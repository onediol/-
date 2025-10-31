/**
 * Класс ОЗУ (оперативная память)
 */
public class RAM extends Component {
    private int capacity; // объем в ГБ
    private int frequency; // частота в МГц
    
    public RAM(String name, int capacity, int frequency) {
        super(name);
        this.capacity = capacity;
        this.frequency = frequency;
    }
    
    @Override
    public void printInfo() {
        System.out.println("ОЗУ: " + name + ", Объем: " + capacity + " ГБ, Частота: " + frequency + " МГц");
    }
    
    // Геттеры и сеттеры
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getFrequency() { return frequency; }
    public void setFrequency(int frequency) { this.frequency = frequency; }
    
    // Переопределение стандартных методов
    @Override
    public String toString() {
        return "ОЗУ{название='" + name + "', объем=" + capacity + " ГБ, частота=" + frequency + " МГц}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RAM ram = (RAM) obj;
        return capacity == ram.capacity && 
               frequency == ram.frequency && 
               name.equals(ram.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + Integer.hashCode(capacity) + Integer.hashCode(frequency);
    }
}
