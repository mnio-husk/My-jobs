import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Lenta {

    private String url;
    private boolean linkChild;

    private TreeSet<Lenta> lentas = new TreeSet<>(Comparator.comparing(o -> o.url));

    public Lenta(String url) {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public boolean isLinkChild()
    {
        return linkChild;
    }

    public void setLinkChild(boolean linkChild)
    {
        this.linkChild = linkChild;
    }

    public List<String> getUrls()
    {
        List<String> urls = new ArrayList<>();
        try
        {
            Document doc  = Jsoup.connect(url).get();
            Elements link = doc.select("a");
            link.forEach(e -> {
                String href = e.absUrl("href");
                if (href.contains(url)) {
                    urls.add(href);
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }

    public TreeSet<Lenta> getLentas() {
        return lentas;
    }

}
