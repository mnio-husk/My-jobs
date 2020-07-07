import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class WorkLink extends RecursiveTask<String> {
    private List<String> links = new ArrayList<>();
    private static String URL;

    public WorkLink(String URL) {
        this.URL = URL;

    }


    private void createLink(String URL,List subTask) throws IOException {
        Document doc;
        Elements section;


        doc = Jsoup.connect(URL).ignoreContentType(true).get();
        section = doc.select("section");
        Elements div = section.select("div");
        Elements a = div.select("a");
        for (Element el : a) {
            String attr = el.attr("href");
            String check = ":";
            String ab = attr.replaceAll("[^:]", "");
            if (check.equals(ab)) {
                WorkLink workLink = new WorkLink(attr);
                workLink.fork();
                subTask.add(workLink);
                links.add(attr + "\n" + "\t");
            }
        }
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    @Override
    protected String compute() {
        StringBuffer sb = new StringBuffer(URL + "\n");
        List<WorkLink> subTask = new ArrayList<>();


        try {
            createLink(URL,subTask);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (WorkLink po : subTask){
            sb.append(po.join());
        }
        return sb.toString();
    }
}
