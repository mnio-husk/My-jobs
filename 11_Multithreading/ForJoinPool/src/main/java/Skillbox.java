import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Skillbox {
    private String URL;
    private TreeSet<Skillbox> skill = new TreeSet<>(Comparator.comparing(o -> o.URL));

    public Skillbox(String URL) {
        this.URL = URL.trim();
    }

    public List<String> createLink() throws IOException {
        Document doc;
        List<String> urls = new ArrayList<>();

        try {
             doc  = Jsoup.connect(URL).get();
            Elements link = doc.select("a");
            link.forEach(e -> {
                String href = e.absUrl("href");
                if (href.contains(URL)) {
                    urls.add(href);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urls;
    }

    public TreeSet<Skillbox> getSkill() {
        return skill;
    }

    public String getUrl() {
        return URL;
    }
}
