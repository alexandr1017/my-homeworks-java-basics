package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String input = scanner.nextLine();
            if (input.equals("")) {
                scanner.close();
                break;
            }
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isDigit(input.charAt(i))) {
                    count++;
                }
            }
            String regex = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$";
            String regexFormat = "[^0-9]";


            if (count > 11 || !input.matches(regex)) {
                System.out.println("Неверный формат номера");
                break;
            }

            String phoneClean = input.replaceAll(regexFormat, "");

            String phoneCleanCorrect;

            if (phoneClean.charAt(0) == '8' && phoneClean.length() == 11) {
                StringBuilder sb = new StringBuilder(phoneClean);
                sb.setCharAt(0, '7');
                phoneCleanCorrect = sb.toString();
                System.out.println(phoneCleanCorrect);
                break;
            }

            if (phoneClean.charAt(0) != '7' && phoneClean.length() < 11) {
                phoneCleanCorrect = "7" + phoneClean;
                System.out.println(phoneCleanCorrect);
                break;
            }

            System.out.println(phoneClean);
            break;

            // TODO:напишите ваш код тут, результат вывести в консоль.

        }
    }
}
