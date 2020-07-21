import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://skillbox.ru";
    private static final String filePath = "C:\\Users\\Михаил\\Desktop\\Links.txt";
    private static List<String> links = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        WorkLink workLink = new WorkLink(URL,URL);
        String siteMap =  new ForkJoinPool(2).invoke(workLink);
        writeFiles(siteMap);


    }


    private static void writeFiles(String map) {

        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Завершено");
    }

}
