import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Loader {


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter("C:\\Users\\Михаил\\Desktop\\numbers.txt");
        PrintWriter writer1 = new PrintWriter("C:\\Users\\Михаил\\Desktop\\numbers1.txt");
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int regionCode = 199;

        executorService.execute(new WorkThread(writer, letters, regionCode));
        executorService.execute(new WorkThread(writer1, letters, regionCode));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);


        System.out.println((System.currentTimeMillis() - start) + " ms");
    }


}
