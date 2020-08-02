import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Updates.push;

public class Main {
    // Создаем коллекцию магазинов
    private static MongoCollection<Document> collectionShop = connectBaseMongoDB().getCollection("shops");

    //И коллекцию продуктов
    private static MongoCollection<Document> collectionProducts = connectBaseMongoDB().getCollection("products");

    public static void main(String[] args) {
        CreateMongo mongo = new CreateMongo();

        //  Удалим из коллекций все документы
        collectionShop.drop();
        collectionProducts.drop();

        mongo.start(collectionShop,collectionProducts);




    }


    private static MongoDatabase connectBaseMongoDB() {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("SkillboxTask");

        return database;
    }

}
