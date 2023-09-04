public class Basket {

    private static int totalCostBaskets = 0; //общая стоимость всех товаров во всех корзинах
    private static int totalGoods = 0; //общее количество товаров во всех корзинах

    private static int count = 0; //общее количество корзин
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount();
        items = "Список товаров:";
        this.limit = 10000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount() {
        Basket.count = Basket.count + 1;
    }

    public static void increaseTotalGoods(int count) {
        Basket.totalGoods = Basket.totalGoods + count;
    }

    public static void increaseTotalCost(int price, int count) {
        Basket.totalCostBaskets = Basket.totalCostBaskets + (count * price);
    }

    public static double averageCostGoods() {
        return Basket.totalCostBaskets / Basket.totalGoods;
    }

    public static double averageCostBasket() {
        return Basket.totalCostBaskets / Basket.count;
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occurred :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        increaseTotalGoods(count);
        increaseTotalCost(price, count);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
        System.out.println("Вес корзины " + getTotalWeight());
        System.out.println("Общая стоимость товаров " + getTotalPrice());
    }
}
