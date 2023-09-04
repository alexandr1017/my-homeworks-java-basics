
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            if (tokens[0].equals("add")) {
                LOGGER.info("Команда: add (Попытка добавления нового клиента).");
                try {
                    executor.addCustomer(tokens[1]);
                    LOGGER.info("Успешно добавлен клиент: " + tokens[1]);
                } catch (ArrayIndexOutOfBoundsException | LessThanFourElementsInputStringException |
                         WrongEmailFormatException |
                         WrongPhoneFormatException ex) {
                    LOGGER.error("Ошибка!", ex);
                }
            } else if (tokens[0].equals("list")) {
                LOGGER.info("Команда: list (Вывод списка клиентов на экран).");
                executor.listCustomers();
            } else if (tokens[0].equals("remove")) {
                LOGGER.info("Команда: remove (Попытка удаления клиента)");
                try {
                    if (tokens.length == 1) {
                        throw new ArrayIndexOutOfBoundsException("Несоответсвие формата ввода. Пример:\n\tremove имя фамилия");
                    }
                    executor.removeCustomer(tokens[1]);
                    LOGGER.info("Клиент успешно удален: " + tokens[1]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    LOGGER.error("Ошибка! Несоответсвие формата ввода.", ex);
                }
            } else if (tokens[0].equals("count")) {
                LOGGER.info("Команда: count (Вывод количества клиентов на экран).");
                System.out.println("There are " + executor.getCount() + " customers");
            } else if (tokens[0].equals("help")) {
                LOGGER.info("Команда: help (Вывод меню Help на экран).");
                System.out.println(HELP_TEXT);
            } else {
                LOGGER.info("Вывод сообщения о вводе несуществующей команды.");
                System.out.println(COMMAND_ERROR);
            }
        }
    }
}
