import au.com.bytecode.opencsv.CSVReader;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.operation.OrderBy;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

public class Main {


    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("Students");


//         Удалим из нее все документы
        collection.drop();

        //Запишем в базу информацию из файла
        for (String read : readeFile()) {
            //Создаем два документа для записи их в БД
            Document students = new Document();
//            Document nestedObject = new Document();
            //Разбиваем данные на отдельные части, чтобы записать их в лист
            String[] line = read.split("\\,");

            List<String> text = new ArrayList<>();
            //Записываем данные из файла в созданные документы
            for (int i = 0; i < line.length; i++) {
                students
                        .append("name", line[0])
                        .append("age", Integer.valueOf(line[1].trim()));

            }
            if (line.length == 3) {
                text.add(line[2]);
            }
            if (line.length == 4) {
                text.add(line[2]);
                text.add(line[3]);
            }
            if (line.length == 5) {
                text.add(line[2]);
                text.add(line[3]);
                text.add(line[4]);
            }

            //Запись из документа nestedObject в документ students
            students.append("Courses", text);
            //Записываем документ students в базу данных или нашу коллекцию
            collection.insertOne(students);
            collection.find().forEach((Consumer<Document>) document -> {
                System.out.println("Документ:\n" + document);
            });
        }


        //(1) Выводит кол-во студентов
        System.out.println("\n"
                +"-----------------------------------------------------------------------------------"
                +"\n");
        System.out.println("Кол-во студентов в базе: " + collection.countDocuments());
        System.out.println("\n"
                +"-----------------------------------------------------------------------------------"
                +"\n");

        //(2) Вывовдит студентов старше 40
        var query = new BasicDBObject("age",  new BasicDBObject("$gt", 40));
        collection.find(query).forEach((Consumer<Document>) doc ->
                System.out.println("Студент, который старше 40 лет :" + doc.toJson()));
        System.out.println("\n"
                +"-----------------------------------------------------------------------------------"
                +"\n");

        //(3)Выводит имя самого молодого студента
        var boy = new BasicDBObject("age",  new BasicDBObject("$gt", 0));
        var up = new BasicDBObject("age",1);
        collection.find(boy).sort(up).limit(1).forEach((Consumer<Document>) doc ->
                System.out.println("Самый молодой на курсе: " + doc.toJson()));
        System.out.println("\n"
                +"-----------------------------------------------------------------------------------"
                +"\n");

        //(4) Выводит список курсов самого старого студента
        var grandFather = new BasicDBObject("age",  new BasicDBObject("$lt", 50));
        var down = new BasicDBObject("age",-1);
        collection.find(grandFather).sort(down).limit(1).forEach((Consumer<Document>) doc ->
                System.out.println("Курсы самого старого студента: " + doc.get("Courses")));
        System.out.println("\n"
                +"-----------------------------------------------------------------------------------"
                +"\n");
    }


    //Метод, чтобы вытащить данные из csv файла
    private static List<String> readeFile() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("C:\\Users\\Михаил\\Desktop\\mongo.csv"), ',', '"', 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] nextLine = new String[0];
        List<String> list = new ArrayList<>();
        while (true) {
            try {
                if (!((nextLine = reader.readNext()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nextLine != null) {
                String line = Arrays.toString(nextLine);
                list.add(line);
            }
        }
        return list;
    }
}
