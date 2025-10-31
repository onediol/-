/**
 * Демонстрационный класс
 */
public class ComputerDemo {
    public static void main(String args[]) {
        // Создание компонентов компьютера
        Winchester hdd = new Winchester("Western Digital", 1000);
        DiskDrive dvd = new DiskDrive("Samsung DVD-RW", "DVD");
        RAM memory = new RAM("Kingston HyperX", 16, 3200);
        
        // Создание компьютера
        Computer myComputer = new Computer("Мой ПК", hdd, dvd, memory);
        
        System.out.println("========== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССОВ ==========\n");
        
        // 1. Основные методы
        System.out.println("1. ОСНОВНЫЕ МЕТОДЫ КОМПЬЮТЕРА:");
        myComputer.powerOn();
        myComputer.printWinchesterSize();
        myComputer.checkForViruses();
        
        // 2. Демонстрация информации о компонентах
        System.out.println("\n2. ИНФОРМАЦИЯ О КОМПОНЕНТАХ:");
        myComputer.printAllComponentsInfo();
        
        // 3. Демонстрация toString()
        System.out.println("\n3. МЕТОД TOSTRING():");
        System.out.println("   Компьютер: " + myComputer.toString());
        System.out.println("   Винчестер: " + hdd.toString());
        System.out.println("   Дисковод: " + dvd.toString());
        System.out.println("   ОЗУ: " + memory.toString());
        
        // 4. Демонстрация equals() и hashCode()
        System.out.println("\n4. СРАВНЕНИЕ ОБЪЕКТОВ:");
        Computer sameComputer = new Computer("Мой ПК", 
            new Winchester("Seagate", 500), 
            new DiskDrive("LG", "CD"),
            new RAM("Corsair", 8, 2666));
        
        Computer otherComputer = new Computer("Офисный ПК", hdd, dvd, memory);
        
        System.out.println("    Сравнение моего ПК с таким же ПК: " + 
                          (myComputer.equals(sameComputer) ? "ОБЪЕКТЫ РАВНЫ" : "объекты разные"));
        System.out.println("    Сравнение моего ПК с офисным ПК: " + 
                          (myComputer.equals(otherComputer) ? "объекты равны" : "ОБЪЕКТЫ РАЗНЫЕ"));
        
        System.out.println("\n5. ХЭШ-КОДЫ ОБЪЕКТОВ:");
        System.out.println("    Мой ПК: " + myComputer.hashCode());
        System.out.println("    Такой же ПК: " + sameComputer.hashCode() + " (совпадает)");
        System.out.println("    Офисный ПК: " + otherComputer.hashCode() + " (отличается)");
        
        // 6. Работа с отдельными компонентами
        System.out.println("\n6. РАБОТА С ОТДЕЛЬНЫМИ КОМПОНЕНТАМИ:");
        System.out.println("    Размер винчестера: " + myComputer.getWinchester().getSize() + " ГБ");
        System.out.println("    Тип дисковода: " + myComputer.getDiskDrive().getType());
        System.out.println("    Объем ОЗУ: " + myComputer.getRam().getCapacity() + " ГБ");
        
        // Изменим объем ОЗУ
        myComputer.getRam().setCapacity(32);
        System.out.println("    Новый объем ОЗУ: " + myComputer.getRam().getCapacity() + " ГБ");
        
        // 7. Выключение компьютера
        System.out.println("\n7. ВЫКЛЮЧЕНИЕ КОМПЬЮТЕРА:");
        myComputer.powerOff();
        
        System.out.println("\n========== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ==========");
    }
}
