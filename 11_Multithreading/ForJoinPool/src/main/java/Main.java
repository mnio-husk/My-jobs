import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String URL = "https://skillbox.ru";
    private static final String filePath = "C:\\Users\\Михаил\\Desktop\\Links.txt";


    public static void main(String[] args) throws IOException {
        Skillbox root = new Skillbox(URL);

        Skillbox skillbox = new ForkJoinPool().invoke(new WorkLink(root));
        writeFiles(skillbox);


    }


    private static void writeFiles(Skillbox lenta) {

        File file = new File(filePath);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Skillbox l : lenta.getSkill()) {
                writer.write(l.getUrl());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Завершено");
    }

    private static void print(Skillbox lenta) {
        print(lenta, 0);
    }

    private static void print(Skillbox lenta, int deep) {
        System.out.println(tabs(deep) + lenta.getUrl());
        for (Skillbox l : lenta.getSkill()) {
            print(l, deep + 1);
        }
    }

    private static String tabs(int deep) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            tabs.append('\t');
        }
        return tabs.toString();
    }
}
