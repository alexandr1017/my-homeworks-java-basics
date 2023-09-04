package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите команду: \"ADD\", \"EDIT\", \"DELETE\" или \"LIST\"");

        TodoList todoList = new TodoList();

        while (true) {
            String input = new Scanner(System.in).nextLine().trim();

            if (input.equals("0")) {break;}

            int index = 0;

            String regex = "(.+?)(\\s+(\\d+)?(.+)?)?";
            String command = input.replaceAll(regex, "$1").trim();
            String indexStr = input.replaceAll(regex, "$3").trim();
            String todo = input.replaceAll(regex, "$4").trim();

            if (!indexStr.isEmpty()) {
                index = Integer.parseInt(indexStr);
            }
            switch (command) {
                case "ADD":
                    if (index == 0) {
                        todoList.add(todo);
                        break;
                    } else {
                        todoList.add(index, todo);
                        break;
                    }
                case "EDIT":
                    todoList.edit(index, todo);
                    break;
                case "DELETE":
                    todoList.delete(index-1);
                    break;
                case "LIST":
                    todoList.getTodos();
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        }
    }
}
