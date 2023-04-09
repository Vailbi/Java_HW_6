import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CPU {
    private String Name;
    private String Vendor;
    private int Cores;

    public CPU(String Name, String Vendor, int Cores) {
        this.Name = Name;
        this.Vendor = Vendor;
        this.Cores = Cores;
    }

    public String getName() {
        return this.Name;
    }

    public String getVendor() {
        return this.Vendor;
    }

    public int getCores() {
        return this.Cores;
    }

    @Override
    public String toString() {
        return this.Name;
    }

    private static final List<CPU> cpuList = new ArrayList<CPU>(){{
        add(new CPU("Intel Core i3 1115G4 3.0GHz", "Intel", 2));
        add(new CPU("Intel Core i5 1155G7 2.5GHz", "Intel", 4));
        add(new CPU("Intel Core i7 12700H 2.3GHz", "Intel", 14));
        add(new CPU("AMD Ryzen 3 3250U 2.6GHz", "AMD", 2));
        add(new CPU("AMD Ryzen 5 5500U 2.1GHz", "AMD", 6));
        add(new CPU("AMD Ryzen 7 5825U 2.0GHz", "AMD", 8));
    }};

    public static CPU GetRandomCPU() {
        Random r = new Random();
        return cpuList.get(r.nextInt(cpuList.size()));
    }
}
