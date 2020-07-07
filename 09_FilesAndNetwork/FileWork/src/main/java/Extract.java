import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Extract {
    private StringBuilder builder = new StringBuilder();
    private List<String> list;
    @Getter
    private List<String> coming;
    @Getter
    private float summOut = 0;
    @Getter
    private float summComing = 0;

    //Расходы
    public void moneyOut() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file/movementList.csv"));
        String line = br.readLine();
        coming = new ArrayList<>();

        while (line != null) {
            String[] world = line.split(",");
            String word = world[7];
            String nul = "0";
            if (word.equals(nul) != true) {
                coming.add(word);
            }
            line = br.readLine();
        }
        for (int i = 1; i < coming.size(); i++) {
            try {
                summOut = summOut + Float.parseFloat(coming.get(i));
            } catch (NumberFormatException e) {
                String cut = coming.get(i).replaceAll("[^0-9]", "");
                summOut = summOut + Float.parseFloat(cut);
            }
        }
        System.out.println("Общая сумма расходов составляет : " + summOut);
    }


    //Доходы
    public void moneyComing() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file/movementList.csv"));
        String line = br.readLine();
        coming = new ArrayList<>();
        while (line != null) {
            String[] world = line.split(",");
            String word = world[6];
            String nul = "0";
            if (word.equals(nul) != true) {
                coming.add(word);
            }
            line = br.readLine();
        }
//        for (String file : coming) {
//            System.out.println(file);
//        }
        for (int i = 1; i < coming.size(); i++) {
            summComing = summComing + Float.parseFloat(coming.get(i));
        }
        System.out.println("Общая сумма дохода составляет : " + summComing);
    }


    //Общая выписка
    public void printExtract() {
        try {
            list = Files.readAllLines(Paths.get("file/movementList.csv"));
            list.forEach(line -> builder.append(line + "\n"));
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extractOutMoney() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file/movementList.csv"));
        String line = br.readLine();
        coming = new ArrayList<>();
        System.out.println("Расходы: ");

        while (line != null) {
            String[] world = line.split(",");
            String word = world[7];
            String filter = word.replaceAll("[^0-9]", "");
            String nul = "0";
            String prob = "";
            if (filter.equals(nul) != true && filter.equals(prob) != true) {
                coming.add(filter);
            }
            line = br.readLine();
        }
        for (String conclusion : coming) {
            System.out.println(conclusion);
        }
    }

}
