package practice.string;

import java.util.Scanner;

public class SequentialWordsNumbers {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите текст:");
            String text = new Scanner(System.in).nextLine();
            System.out.println(sequentialWordsNumbers(text));
        }
    }

    public static String sequentialWordsNumbers(String text) {
        StringBuilder newText = new StringBuilder();
        if (!text.equals("")) {
            int i = 0;
            int start = 0;
            int end = 0;
            while (true) {
                end = text.indexOf(" ", start);
                if (end != -1) {
                    i++;
                    newText.append("(" + i + ") ").append(text.substring(start, end)).append(" ");
                    start = end + 1;
                } else {
                    i++;
                    newText.append("(" + i + ") ").append(text.substring(start, text.length()));
                    break;
                }
            }
        }
        return newText.toString();
    }
}
