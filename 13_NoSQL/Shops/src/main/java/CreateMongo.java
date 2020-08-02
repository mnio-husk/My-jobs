import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.mongodb.client.model.Updates.push;

public class CreateMongo {

    public  void start(MongoCollection<Document> collectionShop,MongoCollection<Document> collectionProducts ){
        boolean circle = true;

        while (circle) {
            System.out.println("Выберите действие: ДОБАВИТЬ_МАГАЗИН 'Название магазина'," +
                    " ДОБАВИТЬ_ТОВАР 'Название товара'," +
                    "  ВЫСТАВИТЬ_ТОВАР 'Название товара' 'Название магазина'  " +
                    " 'СТАТИСТИКА_ТОВАРОВ' " + "\n" +
                    " 'ВЫХОД' - если хотите выйти");
            Scanner scanner = new Scanner(System.in);
            String userEnter = scanner.nextLine();
            String[] name = userEnter.split("\\s");

            switch (name[0]) {
                case "ДОБАВИТЬ_МАГАЗИН":
                    Document shop = new Document();
                    shop
                            .append("name", name[1]);

                    collectionShop.insertOne(shop);
                    System.out.println("Магазин " + name[1] + " успешно добавлен");
                    break;

                //------------------------------------------------
                case "ДОБАВИТЬ_ТОВАР":
                    System.out.println("Укажите цену товара в рублях: ");
                    scanner = new Scanner(System.in);
                    int price = scanner.nextInt();

                    Document product = new Document();
                    product
                            .append("name", name[1])
                            .append("price", price);

                    collectionProducts.insertOne(product);
                    System.out.println("Товар " + name[1] + " успешно добавлен");
                    break;

                //------------------------------------------------
                case "ВЫСТАВИТЬ_ТОВАР":
                    collectionShop.updateOne(Filters.eq("name", name[2]), push("list", name[1]));
                    System.out.println("Товар " + name[1] + " успешно добавлен в список товаров" +
                            " магазина " + name[2]);
                    break;

                //------------------------------------------------
                case "СТАТИСТИКА_ТОВАРОВ":
                    statistics(collectionShop,collectionProducts);
                    break;

                //------------------------------------------------
                case "ВЫХОД":
                    circle = false;
                    break;
            }
        }
    }

    public static void  statistics(MongoCollection<Document> collectionShop, MongoCollection<Document> collectionProducts) {
        collectionShop.aggregate(
                Arrays.asList(
                        Aggregates.lookup("products", "list", "name", "shops"),
                        Aggregates.unwind("$products"),
                        Aggregates.group("$name", Accumulators.avg("avgPrice", "$products.price"),
                                Accumulators.min("minPrice", "$products.price"), Accumulators.max("maxPrice", "$products.price"),
                                Accumulators.sum("sum", "$products.price")


                        )
                )
        ).forEach((Consumer<Document>) document -> {
                    int count = (int) ((int) document.getInteger("sum") / document.getDouble("avgPrice"));
                    int countLt100 = getAvg(document.getString("_id"),collectionProducts );
                    System.out.println("Магазин " + document.getString("_id"));
                    System.out.println("\tВсего в магазине " + document.getString("_id") + " " + count + " товаров");
                    System.out.println("\tСредняя цена товаров в магазине " + document.getString("_id") + " составляет - " + document.getDouble("avgPrice"));
                    System.out.println("\tМинимальная цена товаров в магазине " + document.getString("_id") + " составляет - " + document.getInteger("minPrice"));
                    System.out.println("\tМаксимальная цена товаров в магазине " + document.getString("_id") + " составляет - " + document.getInteger("maxPrice"));
                    System.out.println("\tВсего в магазине " + document.getString("_id") + " " + countLt100 + " товаров дешевле 100 рублей");
                }
        );


    }

    private static int getAvg(String storeName,MongoCollection<Document> collectionProducts) {
        final int[] count = {0};
        BsonDocument query = BsonDocument.parse("{\"products.price\": {$lt: 100}}");
        collectionProducts.aggregate(
                Arrays.asList(
                        Aggregates.lookup("products", "list", "name", "products"),
                        Aggregates.unwind("$products"),
                        Aggregates.match(query),
                        Aggregates.group("$name",
                                Accumulators.avg("avgPrice", "$products.price"),
                                Accumulators.min("minPrice", "$products.price"), Accumulators.max("maxPrice", "$products.price"),
                                Accumulators.sum("sum", "$products.price")


                        )
                )
        ).forEach((Consumer<Document>) document -> {
            if (document.getString("_id").equals(storeName)) {
                int countLt100 = (int) ((int) document.getInteger("sum") / document.getDouble("avgPrice"));
                count[0] = countLt100;
            }

        });

        return count[0];
    }

}
