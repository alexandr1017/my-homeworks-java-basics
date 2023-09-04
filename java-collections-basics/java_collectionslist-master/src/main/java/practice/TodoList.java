package practice;

import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        list.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if (index < list.size() && index >= 0) {
            list.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\"");
        } else {
            list.add(todo);
            System.out.println("Добавлено дело \"" + todo + "\"");
        }
    }

    public void edit(int index, String todo) {
        if (index < list.size() && index >= 0) {
            System.out.println("Дело \"" + list.get(index) + "\" заменено на \"" + todo + "\"");
            list.set(index, todo);
        } else {
            System.out.println("Дела с таким номером не существует");
        }
    }

    public void delete(int index) {
        if (index < list.size() && index >= 0) {
            list.remove(index);
            System.out.println("Дело \"" + list.get(index) + "\" удалено");
        } else {
            System.out.println("Дела с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        if (list.isEmpty()) {
            System.out.println("Дел пока нет, добавьте дело!");
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(i).append(" - ").append(list.get(i)).append("\n");
        }
        System.out.println(str);
        return new ArrayList<>(list);
    }
}