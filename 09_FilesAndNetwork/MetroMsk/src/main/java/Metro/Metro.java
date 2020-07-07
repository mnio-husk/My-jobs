package Metro;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Metro {
    @SerializedName("lines")
    private List<String> lines;
    @SerializedName("stations")
    private Map<String, List<String>> stations;

    public Metro(List<String> lines, Map<String, List<String>> stations) {
        this.lines = lines;
        this.stations = stations;
    }
}
