import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://skillbox.ru";
    private static final String filePath = "C:\\Users\\Михаил\\Desktop\\Links.txt";
    private static List<String> links = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        WorkLink obj = new WorkLink(URL);
        String sitemap = new ForkJoinPool(2).invoke(obj);
        writeFiles(sitemap);



    }

    private static void writeFile() throws IOException {
        FileWriter write = new FileWriter(filePath);
        for(String pi : links){
            write.write(pi);
        }
        write.close();
    }

    private static void writeFiles(String map) {
        
        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Карта создана!");
    }

}
