public class RAM {

    private final RamType ramType;
    private final int volumeRAM;
    private final double weightRAM;

    public RAM(RamType ramType, int volumeRAM, double weightRAM) {
        this.ramType = ramType;
        this.volumeRAM = volumeRAM;
        this.weightRAM = weightRAM;
    }

    public RamType getRamType() {
        return ramType;
    }

    public int getVolumeRAM() {
        return volumeRAM;
    }

    public double getWeightRAM() {
        return weightRAM;
    }

}
