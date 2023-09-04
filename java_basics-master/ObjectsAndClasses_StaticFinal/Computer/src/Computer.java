public class Computer {

    private String vendor;
    private String name;

    private CPU someCPU;
    private RAM someRAM;
    private Storage someStorage;
    private Display someDisplay;
    private Keyboard someKeyboard;

    public Computer(String vendor,
                    String name,
                    CPU someCPU,
                    RAM someRAM,
                    Storage someStorage,
                    Display someDisplay,
                    Keyboard someKeyboard) {

        this.vendor = vendor;
        this.name = name;
        this.someCPU = someCPU;
        this.someRAM = someRAM;
        this.someStorage = someStorage;
        this.someDisplay = someDisplay;
        this.someKeyboard = someKeyboard;
    }

    public double getTotalWeight() {
        return someCPU.getWeightCPU() +
                someRAM.getWeightRAM() +
                someStorage.getWeightStorage() +
                someDisplay.getWeightDisplay() +
                someKeyboard.getWeightKeyboard();
    }

    public String toString() {
        return "Производитель: " + vendor + "\n" +
                "Название: " + name + "\n" +
                "Процессор: " + someCPU.getCpuСompany() + "\n" +
                "Количество ядер процессора: " + someCPU.getCoreCount() + "\n" +
                "Частота процессора (MHz): " + someCPU.getFreq() + "\n" +
                "Вес процессора (гр.): " + someCPU.getWeightCPU() + "\n" +
                "Оперативная память: " + someRAM.getRamType() + "\n" +
                "Объем оперативной памяти (Gb): " + someRAM.getVolumeRAM() + "\n" +
                "Вес оперативной памяти (гр.): " + someRAM.getWeightRAM() + "\n" +
                "Накопитель информации: " + someStorage.getStorageType() + "\n" +
                "Объем накопителя (Mb): " + someStorage.getVolumeStorage() + "\n" +
                "Вес накопителя (гр.): " + someStorage.getWeightStorage() + "\n" +
                "Экран (тип):" + someDisplay.getDisplayType() + "\n" +
                "Диагональ экрана (дюймы): " + someDisplay.getDiagonal() + "\n" +
                "Вес экрана (гр.): " + someDisplay.getWeightDisplay() + "\n" +
                "Тип клавиатуры: " + someKeyboard.getKeyboardType() + "\n" +
                "Наличие RGB: " + someKeyboard.getKeyboardRGB() + "\n" +
                "Вес клавиатуры (гр.) :" + someKeyboard.getWeightKeyboard() + "\n" +
                "Вес ПК (гр.):" + getTotalWeight();

    }

    public void setSomeCPU(CPU someCPU) {
        this.someCPU = someCPU;
    }

    public void setSomeRAM(RAM someRAM) {
        this.someRAM = someRAM;
    }

    public void setSomeStorage(Storage someStorage) {
        this.someStorage = someStorage;
    }

    public void setSomeDisplay(Display someDisplay) {
        this.someDisplay = someDisplay;
    }

    public void setSomeKeyboard(Keyboard someKeyboard) {
        this.someKeyboard = someKeyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public CPU getSomeCPU() {
        return someCPU;
    }

    public RAM getSomeRAM() {
        return someRAM;
    }

    public Storage getSomeStorage() {
        return someStorage;
    }

    public Display getSomeDisplay() {
        return someDisplay;
    }

    public Keyboard getSomeKeyboard() {
        return someKeyboard;
    }

}
