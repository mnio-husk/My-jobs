import java.util.*;

public class Main {
    public static void main(String[] args) {
            System.out.print("Введите номер машины: ");
            Scanner in = new Scanner(System.in);
            String text = in.next();

            //линейный поиск
            ArrayList<String> line = createNumberList();
            long start = System.currentTimeMillis();
            line.contains(text);
            long end = System.currentTimeMillis() - start;
            System.out.println("Поиск перебором: номер найден/не найден, поиск занял " + end + "нс");

            //бинарный поиск
            ArrayList<String> binary = createNumberListBinary();
            long start1 = System.currentTimeMillis();
            Collections.binarySearch(binary,text);
            long end1 = System.currentTimeMillis() - start1;
            System.out.println("Бинарный поиск: номер найден/не найден, поиск занял " + end1 + "нс");

            //HashSet поиск
            HashSet<String> hash = createNumberHashset();
            long start2 = System.currentTimeMillis();
            hash.contains(hash);
            long end2 = System.currentTimeMillis() - start2;
            System.out.println("Поиск в HashSet: номер найден/не найден, поиск занял " + end2 + "нс");

            //TreeSet поиск
            TreeSet<String> tree = createNumberTreeset();
            long start3 = System.currentTimeMillis();
            tree.contains(text);
            long end3 = System.currentTimeMillis() - start3;
            System.out.println("Поиск в TreeSet: номер найден/не найден, поиск занял " + end3 + "нс");
        }


    static ArrayList<String> createNumberList() {
        String[] generation = new String[]{"А", "В", "С", "М", "Т", "Р", "О", "Н", "Е", "У"};
        ArrayList<String> box = new ArrayList<>();
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int f = 1; f < 200; f++) {
                    String letter = generation[i];
                    String number = String.format("%s%d%d%d%s%s%d", letter, j, j, j, letter, letter, f);
                    box.add(number);
                }
            }
        }
        return box;
    }

    static ArrayList<String> createNumberListBinary() {
        String[] generation = new String[]{"А", "В", "С", "М", "Т", "Р", "О", "Н", "Е", "У"};
        ArrayList<String> box = new ArrayList<>();
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int f = 1; f < 200; f++) {
                    String letter = generation[i];
                    String number = String.format("%s%d%d%d%s%s%d", letter, j, j, j, letter, letter, f);
                    box.add(number);
                }
            }
        }
        Collections.sort(box);
        return box;
    }


    static HashSet<String> createNumberHashset() {
        String[] generation = new String[]{"А", "В", "С", "М", "Т", "Р", "О", "Н", "Е", "У"};
        HashSet<String> box = new HashSet<>();
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int f = 1; f < 200; f++) {
                    String letter = generation[i];
                    String number = String.format("%s%d%d%d%s%s%d", letter, j, j, j, letter, letter, f);
                    box.add(number);
                }
            }
        }
        return box;
    }

    static TreeSet<String> createNumberTreeset() {
        String[] generation = new String[]{"А", "В", "С", "М", "Т", "Р", "О", "Н", "Е", "У"};
        TreeSet<String> box = new TreeSet<>();
        for (int i = 0; i < generation.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int f = 1; f < 200; f++) {
                    String letter = generation[i];
                    String number = String.format("%s%d%d%d%s%s%d", letter, j, j, j, letter, letter, f);
                    box.add(number);
                }
            }
        }
        return box;
    }
}
