public class CPU {
    private final double freq;
    private final int coreCount;
    private final CpuСompany cpuСompany;
    private final double weightCPU;

    public CPU(double freq, int coreCount, CpuСompany cpuСompany, double weightCPU) {
        this.freq = freq;
        this.coreCount = coreCount;
        this.cpuСompany = cpuСompany;
        this.weightCPU = weightCPU;
    }


    public double getFreq() {
        return freq;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public CpuСompany getCpuСompany() {
        return cpuСompany;
    }

    public double getWeightCPU() {
        return weightCPU;
    }


}
