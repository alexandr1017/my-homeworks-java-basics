package org.example;



import java.io.IOException;
import java.nio.file.*;
import java.util.*;



public class Main {

    public static final String OUTPUT = "result/sitemap.txt";

    public static void main(String[] args) throws IOException {
        String url = "https://skillbox.ru/";

        ArrayList<String> visitedLinks = new ArrayList<>();

        GoGoLinkTask bigRecursiveTask = new GoGoLinkTask(url,visitedLinks);
        String result = bigRecursiveTask.invoke();

        Files.deleteIfExists(Path.of(OUTPUT));
        Files.write(Path.of(OUTPUT), result.getBytes());

    }
}

