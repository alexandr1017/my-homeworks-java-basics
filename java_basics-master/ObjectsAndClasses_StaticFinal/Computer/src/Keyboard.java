public class Keyboard {
    private final KeyboardType keyboardType;
    private final KeyboardRGB keyboardRGB;
    private final double weightKeyboard;

    public Keyboard(KeyboardType keyboardType, KeyboardRGB keyboardRGB, double weightKeyboard) {
        this.keyboardType = keyboardType;
        this.keyboardRGB = keyboardRGB;
        this.weightKeyboard = weightKeyboard;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public KeyboardRGB getKeyboardRGB() {
        return keyboardRGB;
    }

    public double getWeightKeyboard() {
        return weightKeyboard;
    }
}
