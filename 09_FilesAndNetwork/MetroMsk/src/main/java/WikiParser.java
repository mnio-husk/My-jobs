import Metro.Line;
import Metro.Metro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WikiParser {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final String filePath = "lib/wiki_metroMSK.html";
    private static List<String> linesName = new ArrayList<>();
    private static Map<String, List<String>> stations = new LinkedHashMap<>();
    private static List<String> stationCreate = new ArrayList<>();
    private static List<String> numberLines = new ArrayList<>();


    static void createFileJson() throws IOException {
        final String fileName = "lib/mapMetroMSK.json";
        FileWriter file = new FileWriter("lib/mapMetroMsk.json");
        Metro metro = new Metro(WikiParser.numberLines, WikiParser.stations);
        file.write(GSON.toJson(metro));
    }

    //    Вызов методов

    public void createStation(String nameLine) throws IOException {
        stations.put(nameLine, listStation(nameLine));
    }

    public void nameLines() throws IOException {
        String nul = "";
        for (int i = 0; i < numberLinesTable(); i++) {
            if (!nameLine(i).equals(nul)) {
                if (!linesName.contains(nameLine(i))) {
                    linesName.add(nameLine(i));
                }
            }
        }
    }

    public void numberNameLines() throws IOException {
        String nul = "";
        for (int i = 0; i < numberLinesTable(); i++) {
            if (!numberLines(i).equals(nul)) {
                if (!numberLines.contains(numberLines(i))) {
                    numberLines.add(numberLines(i));
                }
            }
        }
    }

    //Переменные

    public static List<String> listStation(String nameLineMetro) throws IOException {
        List<String> list = new ArrayList<>();
        String htmlFile = parseFile("lib/wiki_metroMSK.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements aElements = doc.select("div#mw-content-text.mw-content-ltr");
        Element ew = aElements.select("table").get(2);
        Elements we = ew.select("tbody");
        int numberStations = ew.select("tr").size();
        for (int i = 1; i < numberStations; i++) {
            Element tr = we.select("tr").get(i);
            Element td = tr.select("td").get(1);
            Elements td1 = tr.select("td");
            Elements span = td1.select("span");
            Elements a = span.select("a");
            String nameLine = a.attr("title");
            String nameStation = td.select("a").get(0).text();
            if (nameLine.equals(nameLineMetro)) {
                list.add(nameStation);
            }
        }
        return list;
    }


    public static String nameLine(int i) throws IOException {
        String htmlFile = parseFile("lib/wiki_metroMSK.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements aElements = doc.select("div#mw-content-text.mw-content-ltr");
        Element ew = aElements.select("table").get(2);
        Elements we = ew.select("tbody");
        Element tr = we.select("tr").get(i);
        Elements td = tr.select("td");
        Elements span = td.select("span");
        Elements a = span.select("a");
        String name = a.attr("title");
        return name;
    }

    private static String numberLines(int i) throws IOException {
        String htmlFile = parseFile("lib/wiki_metroMSK.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements aElements = doc.select("div#mw-content-text.mw-content-ltr");
        Element ew = aElements.select("table").get(2);
        Elements we = ew.select("tbody");
        Element tr = we.select("tr").get(i);
        Elements td = tr.select("td");
        Elements span = td.select("span");
        String[] idLines = span.text().split("\\s");
        return idLines[0];
    }

    private static int numberLinesTable() throws IOException {
        String htmlFile = parseFile("lib/wiki_metroMSK.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements aElements = doc.select("div#mw-content-text.mw-content-ltr");
        Element ew = aElements.select("table").get(2);
        int number = ew.select("tr").size();
        return number;
    }

    private static String parseFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.forEach(line -> builder.append(line + "\n"));
        return builder.toString();
    }

//    удалить ============================================================


    public Map<String, List<String>> getStations() {
        return stations;
    }

    public void setStations(Map<String, List<String>> stations) {
        this.stations = stations;
    }

    public List<String> getLinesName() {
        return linesName;
    }

    public void setLinesName(List<String> linesName) {
        this.linesName = linesName;
    }

    public List<String> getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(List<String> numberLines) {
        this.numberLines = numberLines;
    }
}
