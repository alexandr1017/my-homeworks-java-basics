public class Arithmetic {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("Создан класс с вычеслениями между числами " + a + " и " + b);
    }

    public int sum() {
        System.out.print("Сумма чисел: ");
        return a + b;
    }

    public int mul() {
        System.out.print("Произведение чисел: ");
        return a * b;
    }

    public int max() {
        System.out.print("Максимальное число: ");
        return a > b ? a : b;
    }

    public int min() {
        System.out.print("Минимальное число: ");
        return a < b ? a : b;
    }


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

}