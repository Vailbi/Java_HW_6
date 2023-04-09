import java.util.HashSet;
import java.util.Set;

public class AllLaptop {
    public static void main(String[] args) {
        Set<Laptop> laptops = getLaptopSet(100);
        printLaptops(laptops);
    }

    public static Set<Laptop> getLaptopSet(int listSize) {
        Set<Laptop> laptops = new HashSet<>();
        for (int i = 0; i < listSize; i++) {
            laptops.add(Laptop.generateLaptop());
        }
        return laptops;
    }

    public static void printLaptops(Set<Laptop> laptops) {
        System.out.println(resultMsg);
        int i = 1;
        for (Laptop laptop : laptops) {
            System.out.printf("%d. %s\n", i, laptop);
            i++;
        }
    }

    public static final String resultMsg = "\nПеречень ноутбуков:\n";
}
