package sample;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    private final String path = "C:\\Users\\Михаил\\Desktop\\text.txt";
    private TreeSet<String> list;
    private final String TASK1 = "Задание 1: Заданные два массива " +
            "строк a1 и a2 возвращают отсортированный массив r в лексикографическом " +
            "порядке " + "\n" +
            "\t" + "строк a1, которые являются подстроками строк a2." + "\n" + "\n" +
            "Пример 1:" + "\n" +
            "a1 = [\"arp\", \"live\", \"strong\"]\n" +
            "\n" +
            "a2 = [\"lively\", \"alive\", \"harp\", \"sharp\", \"armstrong\"]\n" +
            "\n" +
            "returns [\"arp\", \"live\", \"strong\"]" + "\n" +
            "Пример 2: " + "\n" +
            "a1 = [\"tarp\", \"mice\", \"bull\"]\n" +
            "\n" +
            "a2 = [\"lively\", \"alive\", \"harp\", \"sharp\", \"armstrong\"]\n" +
            "\n" +
            "returns []" + "\n" +
            "Будьте осторожны: r должен быть без дубликатов.";
    private final String TASK2 = "Задание 2: напишите номер в развернутом виде\n" +
            "\n" +
            "Вам будет дано число, и вам нужно будет вернуть его в виде строки в развернутом виде. " + "\n" +
            "Например:" + "\n" +
            "expanded(12); # Should return \"10 + 2\"" + "\n" +
            "expanded(42); # Should return \"40 + 2\"" + "\n" +
            "expandedm(70304); # Should return \"70000 + 300 + 4\"" + "\n" +
            "Примечание: все числа будут целыми числами больше 0.";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lineEnter;

    @FXML
    private Button download;

    @FXML
    private Button countUp;

    @FXML
    private Button saveButton;

    @FXML
    private ComboBox ComboBox;

    @FXML
    private Label label;


    @FXML
    void initialize() {
        ComboBox.getItems().addAll(TASK1, TASK2);
        ComboBox.setOnAction(event -> {
            String textCom = ComboBox.getSelectionModel().getSelectedItem().toString();
            label.setText(textCom);
        });


        saveButton.setOnAction(event -> {
            String textLine = lineEnter.getText();
            try (FileWriter writer = new FileWriter(path, false)) {
                String textCom = ComboBox.getSelectionModel().getSelectedItem().toString();
                writer.write(textCom);
                writer.append("\n" + "Ответ: " + "\n");
                writer.append(textLine);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });

        download.setOnAction(event -> {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                String txt = file.toString();
                List<String> lines = null;
                try {
                    lines = Files.readAllLines(Paths.get(txt), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String o = "";
                for (String line : lines) {
                    o += line + "\n";
                }
                label.setText(o);

            }

        });

        countUp.setOnAction(event -> {
            if (label.getText().equals(TASK1)){
            list = new TreeSet<>();
            String textLine = lineEnter.getText();
            String[] textSplit = textLine.split("\\,");
            for (int i = 0; i < textSplit.length; i++) {
                list.add(textSplit[i]);
            }
            String textSort = "";
            for (String read : list) {
                textSort += read + ",";
            }
            String textFinish = textSort.substring(0, textSort.length() - 1) + ".";
            label.setText(textFinish);}

            if(label.getText().equals(TASK2)){
                String text = "";
                String numbers = lineEnter.getText();
                char[] number = String.valueOf(numbers).toCharArray();
                String fromString;
                int fromInt;
                int size = number.length;
                int count = 1;
                for (int i = 0; i < number.length; i++) {
                    fromString = String.valueOf(number[i]);
                    fromInt = Integer.parseInt(fromString);
                    int result = fromInt * (int) Math.pow(10, size - count);
                    text += result + "+";
                    count++;
                }
                String textFinish = text.substring(0, text.length() - 1);
                label.setText(textFinish);
            }

        });


//        countUp.setOnAction(event -> {
//            String text = "";
//            String numbers = lineEnter.getText();
//            char[] number = String.valueOf(numbers).toCharArray();
//            String fromString;
//            int fromInt;
//            int size = number.length;
//            int count = 1;
//            for (int i = 0; i < number.length; i++) {
//                fromString = String.valueOf(number[i]);
//                fromInt = Integer.parseInt(fromString);
//                int result = fromInt * (int) Math.pow(10, size - count);
//                text += result + "+";
//                count++;
//            }
//            String textFinish = text.substring(0, text.length() - 1);
//            label.setText(textFinish);
//
//
//        });


    }
}




