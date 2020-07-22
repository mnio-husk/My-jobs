import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args)
    {
        String url = "https://skillbox.ru/";
        Lenta root = new Lenta(url);

        Lenta lenta = new ForkJoinPool().invoke(new LinkLenta(root));
        print(lenta);
    }

    private static void print(Lenta lenta) {
        print(lenta, 0);
    }

    private static void print(Lenta lenta, int deep) {
        System.out.println(tabs(deep) + lenta.getUrl());
        for (Lenta l : lenta.getLentas()) {
            print(l, deep + 1);
        }
    }

    private static String tabs(int deep) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            tabs.append('\t');
        }
        return tabs.toString();
    }
}
