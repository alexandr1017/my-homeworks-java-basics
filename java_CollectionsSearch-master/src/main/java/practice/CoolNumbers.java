package practice;

import java.util.*;

public class CoolNumbers {
    static List<String> list = new ArrayList<>();

    public static List<String> generateCoolNumbers() {


        String[] chars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х",};

        for (int region = 1; region < 200; region++) {
            for (String firstLetter : chars) {
                for (String twoLetter : chars) {
                    for (String threeLetter : chars) {
                        for (int m = 1; m < 10; m++) {
                            list.add(String.format("%s%d%d%d%s%s%02d",
                                    firstLetter,
                                    m, m, m,
                                    twoLetter,
                                    threeLetter,
                                    region));
                        }
                    }
                }
            }
        }
        return list;
    }


    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> list, String number) {
        return Collections.binarySearch(list, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }


    public static void bruteForceSpeed(List<String> list, String number) {

        long time = System.nanoTime();
        boolean flag = bruteForceSearchInList(list, number);
        time = System.nanoTime() - time;
        if (!flag) {
            System.out.printf("Поиск перебором: номер не найден, поиск занял %dнс\n", time);
        } else {
            System.out.printf("Поиск перебором: номер найден, поиск занял %dнс\n", time);
        }
    }

    public static void binarySearchInListSpeed(List<String> list, String number) {
        Collections.sort(list);
        long time = System.nanoTime();
        boolean flag = binarySearchInList(list, number);
        time = System.nanoTime() - time;
        if (!flag) {
            System.out.printf("Бинарный поиск: номер не найден, поиск занял %dнс\n", time);
        } else {
            System.out.printf("Бинарный поиск: номер найден, поиск занял %dнс\n", time);
        }
    }

    public static void searchInHashSetSpeed(List<String> list, String number) {
        HashSet <String> hashSet = new HashSet<>(list);
        long time = System.nanoTime();
        boolean flag = searchInHashSet(hashSet, number);
        time = System.nanoTime() - time;
        if (!flag) {
            System.out.printf("Поиск в HashSet: номер не найден, поиск занял %dнс\n", time);
        } else {
            System.out.printf("Поиск в HashSet: номер найден, поиск занял %dнс\n", time);
        }
    }

    public static void searchInTreeSetSpeed(List<String> list, String number) {
        TreeSet <String> treeSet = new TreeSet<>(list);
        long time = System.nanoTime();
        boolean flag = searchInTreeSet(treeSet, number);
        time = System.nanoTime() - time;
        if (!flag) {
            System.out.printf("Поиск в TreeSet: номер не найден, поиск занял %dнс\n", time);
        } else {
            System.out.printf("Поиск в TreeSet: номер найден, поиск занял %dнс\n", time);
        }
    }
}
