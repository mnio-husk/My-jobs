package sample;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller {
    private final String path = "C:\\Users\\Михаил\\Desktop\\text.txt";

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
        ComboBox.getItems().addAll("Задание 1: Заданные два массива " +
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
                        "Будьте осторожны: r должен быть без дубликатов.",
                "Напишите номер в развернутом виде\n" +
                        "\n" +
                        "Вам будет дано число, и вам нужно будет вернуть его в виде строки в развернутом виде. " + "\n" +
                        "Например:" + "\n" +
                        "expanded(12); # Should return \"10 + 2\"" + "\n" +
                        "expanded(42); # Should return \"40 + 2\"" + "\n" +
                        "expandedm(70304); # Should return \"70000 + 300 + 4\"" + "\n" +
                        "Примечание: все числа будут целыми числами больше 0.");
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
                /*
                 * Какие-то действия.
                 */
                String txt = file.toString();
                List<String> lines = null;
                try {
                    lines = Files.readAllLines(Paths.get(txt), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String o = "";
                for(String line: lines){
                    o += line + "\n";
                }
                label.setText(o);

            }

        });


    }
}



