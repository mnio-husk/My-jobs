import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        WikiParser obj = new WikiParser();
        obj.numberNameLines();
        System.out.println(obj.getNumberLines());
        obj.nameLines();
        System.out.println(obj.getLinesName());
        for (int i = 0; i < obj.getLinesName().size(); i++){
            obj.createStation(obj.getLinesName().get(i));
        }
        System.out.println(obj.getStations());
        WikiParser.createFileJson();
    }

}
