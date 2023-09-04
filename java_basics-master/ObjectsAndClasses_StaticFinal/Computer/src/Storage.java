public class Storage {

    private final StorageType storageType;
    private final int volumeStorage;
    private final double weightStorage;

    public Storage(StorageType storageType, int volumeStorage, double weightStorage) {
        this.storageType = storageType;
        this.volumeStorage = volumeStorage;
        this.weightStorage = weightStorage;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public int getVolumeStorage() {
        return volumeStorage;
    }

    public double getWeightStorage() {
        return weightStorage;
    }

}
