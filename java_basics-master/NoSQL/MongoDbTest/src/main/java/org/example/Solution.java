package org.example;

/*
* Напишите программу, которая получает на вход csv файл с данными о студентах: имя, возраст и список курсов через запятую, и вставляет эти данные в MongoDB. (csv файл приложен к этому уроку)
После этого программа должна получить из БД и вывести на экран:
— общее количество студентов в базе.
— количество студентов старше 40 лет.
— имя самого молодого студента.
— список курсов самого старого студента.
*/

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.bson.BsonDocument;
import org.bson.Document;


import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.function.Consumer;

public class Solution {
    public static void main(String[] args) throws IOException, CsvException {


        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("solution");
        MongoCollection<Document> collection = database.getCollection("Students");
        collection.drop();

//        List<Document> documentBuffer = new ArrayList<>();


        //Парсим csv файл при помощи opencsv lib
        CSVReader reader = new CSVReader(new FileReader("mongo.csv"));
        List<String[]> records = reader.readAll();

        for (String[] record : records) {
            String name = record[0];
            int age = Integer.parseInt(record[1]);
            String courses = record[2];
            collection.insertOne(Document.parse(String.format("{Name: \"%s\", Age: %d, Courses: \"%s\"}", name, age, courses)));


//            Document document = new Document()
//                    .append("Name", name)
//                    .append("Age", age)
//                    .append("Courses", courses);
//            documentBuffer.add(document);

//            if (documentBuffer.size() > 10) {
//                collection.insertMany(documentBuffer);
//                documentBuffer.clear();
//            }


        }


        System.out.println("Коллекция студентов и их курсов из CSV файла:\n");
        collection.find().forEach(
                (Consumer<Document>) doc -> {
                    System.out.println("\n" + doc);
                });


        //Задание 1
        System.out.println("Общее количество студентов в базе:\n" + collection.countDocuments());

        //Задание 2
        BsonDocument queryOne = BsonDocument.parse("{Age: {$gt: 40}}");
        System.out.println("Количество студентов старше 40 лет:\n" + collection.countDocuments(queryOne));

        //Задание 3 (Сортировка по возрастанию возраста, вывод топ элемента)
        BsonDocument queryTwo = BsonDocument.parse("{Age: 1}");
        collection.find().sort(queryTwo).limit(1).forEach((Consumer<Document>) doc -> {
            System.out.println("Самый молодой студент:\n" + doc.getString("Name"));
        });

        //Задание 4 (Сортировка по убыванию возраста, вывод топ элемента )
        BsonDocument queryThree = BsonDocument.parse("{Age: -1}");
        collection.find().sort(queryThree).limit(1).forEach((Consumer<Document>) doc -> {
            System.out.println("Список курсов самого старого студента:\n" + doc.getString("Courses"));
        });

        mongoClient.close();

    }
}
