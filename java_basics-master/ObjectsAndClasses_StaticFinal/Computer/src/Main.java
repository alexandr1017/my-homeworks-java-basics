public class Main {
    public static void main(String[] args) {
        Computer c1 = new Computer("ASUS", "A3435KK",
                new CPU(4.5, 12, CpuСompany.AMD, 10.1),
                new RAM(RamType.DDR5, 32, 50),
                new Storage(StorageType.SSD, 1024, 80),
                new Display(27, DisplayType.IPS, 4000),
                new Keyboard(KeyboardType.MECHANICAL, KeyboardRGB.YES, 350));

        System.out.println(c1.toString());
        System.out.println();

        Computer c2 = new Computer("MSI", "MK43E",
                new CPU(3.2, 8, CpuСompany.INTEL, 12.1),
                new RAM(RamType.DDR4, 16, 45),
                new Storage(StorageType.SSD, 2024, 90),
                new Display(21, DisplayType.VA, 3000),
                new Keyboard(KeyboardType.MEMBRANOUS, KeyboardRGB.NO, 300));

        System.out.println(c2.toString());
    }
}