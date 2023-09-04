package practice;

import java.util.*;

public class EmailList {
    public static final String WRONG_EMAIL_ANSWER = "\"Неверный формат email\"";
    private final String REGEX_EMAIL = "^([\\w-]+)@([\\w-]+)\\.(\\w{2,6})$";

    private final TreeSet<String> set = new TreeSet<>();

    public void add(String email) {

        if (!emailCorrect(email)) {
            System.out.println(WRONG_EMAIL_ANSWER);
            return;
        }

        set.add(email.toLowerCase());
    }

    public List<String> getSortedEmails() {

        ArrayList<String> strings = new ArrayList<>(set);

        StringBuilder str = new StringBuilder();

        for (String string : strings) {
            str.append(string).append("\n");
        }
        System.out.println(str);
        return strings;
    }

    private boolean emailCorrect(String email) {
        return email.matches(REGEX_EMAIL);
    }

}
