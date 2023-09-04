package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        PhoneBook phoneBook = new PhoneBook();
        while (true) {

            System.out.println("Введите номер, имя или команду:");
            String input = new Scanner(System.in).nextLine().trim();


            if (input.equals("0")) {
                break;}
            if (input.equalsIgnoreCase("LIST")) {
                System.out.println(phoneBook.getAllContacts());
                continue;}
            if (!PhoneBook.phoneCorrect(input) && !PhoneBook.nameCorrect(input)) {
                System.out.println(PhoneBook.WRONG_INPUT_ANSWER);
                continue;}

            if (PhoneBook.phoneCorrect(input)) {
                if (phoneBook.getContactByPhone(input).isBlank()) {
                    System.out.println("Такого номера нет в телефонной книге.");
                    System.out.println("Введите имя абонента для номера \"" + input + "\"");
                    String name = new Scanner(System.in).nextLine().trim();
                    if (PhoneBook.nameCorrect(name)) {phoneBook.addContact(input, name);
                    } else {System.out.println(PhoneBook.WRONG_INPUT_ANSWER);}
                } else {System.out.println(phoneBook.getContactByPhone(input));}
            }

            if (PhoneBook.nameCorrect(input)) {
                if (phoneBook.getContactByName(input).isEmpty()) {
                    System.out.println("Такого имени в телефонной книге нет.");
                    System.out.println("Введите номер телефона для абонента \"" + input + "\"");
                    String phone = new Scanner(System.in).nextLine().trim();
                    if (PhoneBook.phoneCorrect(phone)) {phoneBook.addContact(phone, input);
                    } else {System.out.println(PhoneBook.WRONG_INPUT_ANSWER);}
                } else {System.out.println(phoneBook.getContactByName(input));}
            }
        }
    }
}