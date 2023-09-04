package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

//Запуск контейнера с MongoDB: docker run --rm --name skill-mongo -p 127.0.0.1:27017:27017/tcp -d scalar4eg/skill-mongo-with-hacker


public class MongoDbTest {
    public static void main(String[] args) {

        //объект клиента
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        //создаем базу данных
        MongoDatabase database = mongoClient.getDatabase("local");
        //создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("TestSkillboxDemo");
        //удалим из нее все документы
        collection.drop();


        //Создадим первый документ
        Document firstDocument = new Document()
                .append("Type",1)
                .append("Description", "Это наш первый документ в MongoDB")
                .append("Author", "Я")
                .append("Time",new SimpleDateFormat().format(new Date()));
        //создадим вложенный документ
        Document nestedDocument = new Document()
                .append("Course", "NoSQL Базы Данных")
                .append("Author", "Горшняков Александр");

        firstDocument.append("Skillbox", nestedDocument);

        //вставим документ в коллекцию
        collection.insertOne(firstDocument);

        collection.find().forEach(
                (Consumer<Document>) doc -> {
                    System.out.println("Наш первый документ:\n" + doc);
                });

        //используем JSON-синтаксис для создания объекта
        Document secondDocument = Document.parse(
          "{Type: 2, Description: \"Мы создали и нашли этот документ с помощью синтаксиса JSON\"}"
        );
        collection.insertOne(secondDocument);

        //используем JSON-синтаксис для написания запроса
        BsonDocument query = BsonDocument.parse("{Type: {$eq: 2}}");
        collection.find(query).forEach((Consumer<Document>) doc -> {
            System.out.println("Наш второй документ:\n" + doc);
        });
    }
}