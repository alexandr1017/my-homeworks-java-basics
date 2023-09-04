package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        EmailList emailList = new EmailList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду: \"ADD\", \"LIST\"");

            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }

            String regex = "(.+?)(\\s+(.+)?)?";
            String command = input.replaceAll(regex, "$1").trim();
            String email = input.replaceAll(regex, "$3").trim();

            switch (command) {
                case "ADD":
                    emailList.add(email);
                    break;
                case "LIST":
                    emailList.getSortedEmails();
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        }
    }
}
