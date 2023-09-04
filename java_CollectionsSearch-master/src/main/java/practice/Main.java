package practice;

import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {
        List<String> list = CoolNumbers.generateCoolNumbers();
        System.out.println(list);

        System.out.println("Сгенерировано красивых номеров: " + list.size());
        System.out.println("Введите красивый номер: " + list.size());

        while (true) {
            String input = new Scanner(System.in).nextLine().trim();
            if (input.equals("0")) {
                break;
            }
            CoolNumbers.bruteForceSpeed(CoolNumbers.list,input);
            CoolNumbers.binarySearchInListSpeed(CoolNumbers.list,input);
            CoolNumbers.searchInTreeSetSpeed(CoolNumbers.list,input);
            CoolNumbers.searchInHashSetSpeed(CoolNumbers.list,input);
        }
    }
}
