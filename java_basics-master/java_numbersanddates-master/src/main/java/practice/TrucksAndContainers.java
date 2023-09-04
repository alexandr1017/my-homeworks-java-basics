package practice;

import java.awt.*;
import java.util.Scanner;

public class TrucksAndContainers {
    private static final int BOXES_IN_CONTAINER = 27;
    private static final int CONTAINERS_IN_TRUCK = 12;

    public static String newLine = System.lineSeparator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        int containers = 0;
        int trucks = 0;

        for (int i = 1; i <= boxes; i++) {

            if ((i % BOXES_IN_CONTAINER) == 1) {

                containers++;

                if ((containers % CONTAINERS_IN_TRUCK) == 1) {

                    trucks++;

                    System.out.println("Грузовик: " + trucks);
                }
                System.out.println("\tКонтейнер: " + containers);
            }
            System.out.println("\t\tЯщик: " + i);
        }

        System.out.println("Необходимо:" + newLine + "грузовиков - " + trucks + " шт." +
                newLine + "контейнеров - " + containers + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}
