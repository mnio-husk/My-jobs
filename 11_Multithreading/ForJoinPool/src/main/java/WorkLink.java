import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

public class WorkLink extends RecursiveTask<Skillbox> {
    private static String URL;
    private static final Set<String> allUrls = new HashSet<>();
    private Skillbox skillbox;


    public WorkLink(Skillbox skillbox) {
        this.skillbox = skillbox;
    }


    @Override
    protected Skillbox compute() {
        List<WorkLink> listTask = new ArrayList<>();
        try {
            for (String link : skillbox.createLink()) {
                if (allUrls.contains(link)) {
                    continue;
                }
                synchronized (allUrls) {
                    allUrls.add(link);
                }
                WorkLink workLink = new WorkLink(new Skillbox(link));
                workLink.fork();
                listTask.add(workLink);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WorkLink linkSkillbox : listTask) {
            skillbox.getSkill().add(linkSkillbox.join());
        }
        return skillbox;
    }

}
