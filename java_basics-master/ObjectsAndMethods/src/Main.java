public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add ("Milk", 100, 2, 3.3);
        basket.add ("Bread", 50, 1, 0.5);
        basket.add ("Meat", 1000,2,1);
        basket.print("Корзина");

        System.out.println("Общее количество созданных корзин: " + Basket.getCount());
        System.out.println("Средняя стоимость корзины: " + Basket.averageCostBasket());

        Basket katyaBasket = new Basket();
        katyaBasket.add("Sugar", 70,5,5);
        katyaBasket.add("Water", 150,2, 1);
        katyaBasket.print("Корзина Кати");

        System.out.println("Общее количество созданных корзин: " + Basket.getCount());
        System.out.println("Средняя стоимость корзины: " + Basket.averageCostBasket());
        System.out.println("Средняя стоимость товара: " + Basket.averageCostGoods());


        Arithmetic ar = new Arithmetic(5, 12);
        System.out.println(ar.sum());


    }
}
