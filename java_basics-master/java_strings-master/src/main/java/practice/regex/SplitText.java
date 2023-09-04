package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitText {

    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        String text = new Scanner(System.in).nextLine();
        System.out.println(splitTextIntoWords(text));
    }
    public static String splitTextIntoWords(String text) {
        String[] words = text.split("[^a-zA-Zа-яА-Я]+");
        return String.join("\n", words);
    }
    public static String splitTextIntoWordsTwo(String text) {
        StringBuffer s = new StringBuffer();
        if (!text.equals("")) {
            Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                s.append(matcher.group()).append("\n");
            }
        }
        return s.toString().trim();
    }

    public static String[] splitTextIntoSentences (String text) {
        String[] sentences = text.split("(?<=[.!?])\\s*");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
        return sentences;
    }
}