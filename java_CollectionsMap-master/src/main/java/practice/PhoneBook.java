package practice;

import java.util.*;

public class PhoneBook {
    public static final String WRONG_INPUT_ANSWER = "Неверный формат ввода\n";
    private static final String REGEX_PHONE = "^(\\+7|7|8)?[\\s\\-]?\\(?[489]" +
            "[0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$";
    private static final String REGEX_NAME = "[а-яА-Яa-zA-Z]+";


    private Map<String, String> map = new TreeMap<>();

    public void addContact(String phone, String name) {

        if (inputWrongAlert(phone, name)) {
            return;
        }
        putNamePhoneInMap(phoneBuilder(phone, name), name);
    }

    public String getContactByPhone(String phone) {
        String out = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (phone.equals(entry.getValue())) {
                out = entry.getKey() + " - " + entry.getValue();
            }
        }
        return out;
    }


    public Set<String> getContactByName(String name) {
        TreeSet<String> set = new TreeSet<>();
        String out;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (name.equals(entry.getKey())) {
                out = entry.getKey() + " - " + entry.getValue();
                set.add(out);
            }
        }
        return new TreeSet<>(set);
    }


    public Set<String> getAllContacts() {
        TreeSet<String> set = new TreeSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            set.add(entry.getKey() + " - " + entry.getValue());
        }
        return new TreeSet<>(set);
    }

    public static boolean phoneCorrect(String phone) {
        return phone.matches(REGEX_PHONE);
    }

    public static boolean nameCorrect(String name) {
        return name.matches(REGEX_NAME);
    }

    private String phoneBuilder (String phone, String name) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().contains(name) && entry.getValue().contains(phone)) {
                System.out.println("Контакт с таким именем и номером уже существует");
                break;
            } else if (entry.getValue().contains(phone)) {
                map.remove(entry.getKey());
                break;
            } else if (entry.getKey().contains(name)) {
                map.remove(entry.getKey());
                phone = entry.getValue() + ", " + phone;
                break;
            }
        }
        return phone;
    }

    private boolean inputWrongAlert(String phone, String name) {
        if (!phoneCorrect(phone) || name.isEmpty() || name.isBlank() || !nameCorrect(name)) {
            System.out.println(WRONG_INPUT_ANSWER);
            return true;
        } else {
            return false;
        }
    }

    private void putNamePhoneInMap(String phone, String name) {
        map.put(name, phone);
        System.out.println("Контакт сохранен!\n");
    }
}