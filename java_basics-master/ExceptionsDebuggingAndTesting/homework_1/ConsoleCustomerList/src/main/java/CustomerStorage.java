import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    public static final String REGEX_PHONE = "\\+7\\s?[(]{0,1}9[0-9]{2}[)]{0,1}\\s?\\d{3}-{0,1}\\d{2}-{0,1}\\d{2}";
    public static final String REGEX_EMAIL = "^([\\w-.]+)@([\\w-]+)\\.(\\w{2,6})$";

    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new LessThanFourElementsInputStringException("Ввод более или менее четырёх элементов! Пример:\n\tadd имя фамилия почта телефон");
        }
        if (!components[INDEX_PHONE].matches(REGEX_PHONE)) {
            throw new WrongPhoneFormatException("Неверный формат номера телефона!");
        }
        if (!components[INDEX_EMAIL].matches(REGEX_EMAIL)) {
            throw new WrongEmailFormatException("Неверный формат email");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }


    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}