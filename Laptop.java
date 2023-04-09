import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Laptop {
    private CPU Cpu;
    private int RAMSizeGB;
    private int DiskSizeGB;
    private String DiskType;
    private int DisplaySizeInch;
    private String DisplayType;
    private String Color;
    private String OS;
    private double PriceRUR;

    public Laptop(CPU CPU, int RAMSizeGB, int DiskSizeGB, String DiskType, int DisplaySizeInch, String DisplayType, String Color, String OS, double PriceRUR) {
        this.Cpu = CPU;
        this.RAMSizeGB = RAMSizeGB;
        this.DiskSizeGB = DiskSizeGB;
        this.DiskType = DiskType;
        this.DisplaySizeInch = DisplaySizeInch;
        this.DisplayType = DisplayType;
        this.Color = Color;
        this.OS = OS;
        this.PriceRUR = PriceRUR;
    }

    public CPU getCPU() {
        return this.Cpu;
    }

    public int getRAMSizeGB() {
        return this.RAMSizeGB;
    }

    public int getDiskSizeGB() {
        return this.DiskSizeGB;
    }

    public String getDiskType() {
        return this.DiskType;
    }

    public int getDisplaySizeInch() {
        return this.DisplaySizeInch;
    }

    public String getDisplayType() {
        return this.DisplayType;
    }

    public String getColor() {
        return this.Color;
    }

    public String getOS() {
        return this.OS;
    }

    public double getPriceRUR() {
        return this.PriceRUR;
    }

    public boolean hasCpuVendor(String vendor) {
        return this.Cpu.getVendor().toLowerCase().equals(vendor.toLowerCase());
    }

    public boolean hasOS(String OS) {
        return this.getOS().toLowerCase().equals(OS.toLowerCase());
    }

    public boolean hasMoreOrEqualsCores(int cores) {
        return this.getCPU().getCores() >= cores;
    }

    public boolean hasMoreOrEqualsRAM(int ram) {
        return this.getRAMSizeGB() >= ram;
    }

    public boolean hasMoreOrEqualsDiskSize(int diskSize) {
        return this.getDiskSizeGB() >= diskSize;
    }

    public boolean cheaperThenMaxPrice(double maxPrice) {
        return this.getPriceRUR() <= maxPrice;
    }

    @Override
    public String toString() {
        return String.format("Laptop %s / %d GB RAM / %d GB %s / %s = %.2f RUR",
            this.Cpu,
            this.RAMSizeGB,
            this.DiskSizeGB,
            this.DiskType,
            this.OS,
            this.PriceRUR);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return this.Cpu.equals(laptop.Cpu) && this.RAMSizeGB == laptop.RAMSizeGB && this.DiskSizeGB == laptop.DiskSizeGB && this.OS.equals(laptop.OS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cpu, RAMSizeGB, DiskSizeGB, DiskType, OS);
    }


    private static List<Integer> ramSizes = Arrays.asList(4, 6, 8, 12, 16, 32);
    private static List<String> diskTypes = Arrays.asList("HDD", "SSD", "NVMe");
    private static List<Integer> diskSizes = Arrays.asList(128, 256, 512, 1024, 2048);
    private static List<String> displayTypes = Arrays.asList("TN", "MVA", "IPS");
    private static List<Integer> displaySizes = Arrays.asList(10, 12, 13, 14, 15, 17);
    private static List<String> colorList = Arrays.asList("Black", "White", "Silver", "Blue", "Red");
    private static List<String> OSList = Arrays.asList("NoOS", "FreeDOS", "Linux", "Windows");

    public static Laptop generateLaptop() {
        Random r = new Random();
        CPU cpu = CPU.GetRandomCPU();
        int RAMSizeGB = ramSizes.get(r.nextInt(ramSizes.size()));
        int DiskSizeGB = diskSizes.get(r.nextInt(diskSizes.size()));
        String DiskType = diskTypes.get(r.nextInt(diskTypes.size()));
        int DisplaySizeInch = displaySizes.get(r.nextInt(displaySizes.size()));
        String DisplayType = displayTypes.get(r.nextInt(displayTypes.size()));
        String Color = colorList.get(r.nextInt(colorList.size()));
        String OS = OSList.get(r.nextInt(OSList.size()));
        double PriceRUR = r.nextDouble() * 100000;
        return new Laptop(cpu, RAMSizeGB, DiskSizeGB, DiskType, DisplaySizeInch, DisplayType, Color, OS, PriceRUR);
    }
}
