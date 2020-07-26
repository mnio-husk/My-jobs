import au.com.bytecode.opencsv.CSVReader;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("Students");

        // Удалим из нее все документы
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
                        .append("age", line[1]);

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
//            //Запись из листа в документ nestedObject
//            nestedObject.append("name", text);
            //Запись из документа nestedObject в документ students
            students.append("Courses", text);
            //Записываем документ students в базу данных или нашу коллекцию
            collection.insertOne(students);
            collection.find().forEach((Consumer<Document>) document -> {
                System.out.println("Документ:\n" + document);
            });


        }
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
