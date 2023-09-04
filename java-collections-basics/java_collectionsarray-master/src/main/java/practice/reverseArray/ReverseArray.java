package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.

        String temp;

        for (int i = 0; i < strings.length / 2; i++) {
            temp = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = strings[i];
            strings[i] = temp;
        }
        return strings;
    }
}