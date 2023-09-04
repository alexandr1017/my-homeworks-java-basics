public class Display {

    private final double diagonal;
    private final DisplayType displayType;
    private final double weightDisplay;

    public Display(double diagonal, DisplayType displayType, double weightDisplay) {
        this.diagonal = diagonal;
        this.displayType = displayType;
        this.weightDisplay = weightDisplay;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public double getWeightDisplay() {
        return weightDisplay;
    }


}
