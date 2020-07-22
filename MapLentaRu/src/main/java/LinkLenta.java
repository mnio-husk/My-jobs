import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class LinkLenta extends RecursiveTask<Lenta> {
    private Lenta lenta;
    private static final Set<String> allUrls = new HashSet<>();

    public LinkLenta(Lenta lenta) {
        this.lenta = lenta;
    }

    @Override
    protected Lenta compute() {
        List<LinkLenta> taskList = new ArrayList<>();

        for (String link : lenta.getUrls()) {
            if (allUrls.contains(link)) {
                continue;
            }
            synchronized (allUrls) {
                allUrls.add(link);
            }
            LinkLenta task = new LinkLenta(new Lenta(link));
            task.fork();
            taskList.add(task);
        }

        for (LinkLenta linkLenta : taskList) {
            lenta.getLentas().add(linkLenta.join());
        }

        return lenta;
    }
}
