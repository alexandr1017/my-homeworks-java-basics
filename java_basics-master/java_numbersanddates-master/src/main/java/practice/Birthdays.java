package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {
    public static String newLine = System.lineSeparator();

    public static void main(String[] args) {

        int day = 12;
        int month = 10;
        int year = 1993;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(new Locale("us"));
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        String text = "";

        for (int i = 0; !birthday.isAfter(today); i++) {
            text = text + i + " - " + formatter.format(birthday) + newLine;
            birthday = birthday.plusYears(1);
        }
        return text;
    }
}
