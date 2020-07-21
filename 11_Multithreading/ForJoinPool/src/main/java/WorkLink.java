import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

public class WorkLink extends RecursiveTask<String> {
    private static CopyOnWriteArraySet<String> links = new CopyOnWriteArraySet<>();
    private static String URL;
    private static String startUrl;

    public WorkLink(String URL) {
        this.URL = URL.trim();

    }

    public WorkLink(String URL, String startUrl) {
        this.URL = URL.trim();
        WorkLink.startUrl = startUrl.trim();

    }


    private void createLink(String URL, Set subTask) throws IOException {
        Document doc;
        Elements section;



        try {
            Thread.sleep(100);
            Connection.Response res = Jsoup.connect(URL).execute();
            String contentType = res.contentType();
            String checkOne = "application/pdf";

            doc = Jsoup.connect(URL).ignoreContentType(true).get();
            section = doc.select("section");
            Elements div = section.select("div");
            Elements a = div.select("a");
            for (Element el : a) {
                String attr = el.attr("href");
                String check = ":";
                String ab = attr.replaceAll("[^:]", "");
//                if (check.equals(ab)) {
//                    if (contentType.equals(checkOne)) {
                        WorkLink workLink = new WorkLink(attr);
                        workLink.fork();
                        subTask.add(workLink);
                        links.add(attr);
//                    }
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String compute() {
        StringBuffer sb = new StringBuffer(URL + "\n");
        Set<WorkLink> subTask = new HashSet<>();


        try {
            createLink(URL, subTask);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WorkLink po : subTask) {
            sb.append(po.join());
        }
        return sb.toString();
    }

    public static CopyOnWriteArraySet<String> getLinks() {
        return links;
    }

    public static void setLinks(CopyOnWriteArraySet<String> links) {
        WorkLink.links = links;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        WorkLink.URL = URL;
    }

    public static String getStartUrl() {
        return startUrl;
    }

    public static void setStartUrl(String startUrl) {
        WorkLink.startUrl = startUrl;
    }
}
