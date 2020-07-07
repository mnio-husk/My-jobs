import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Extract object = new Extract();
        object.moneyComing();
        object.moneyOut();
        object.extractOutMoney();

    }

    private static void CopyDirectory() throws IOException {
        System.out.println("Введите путь копируемой папки: ");
        Scanner sc = new Scanner(System.in);
        String from = sc.next();
        File one = new File(from);

        System.out.println("Введите путь в копируемую папку: ");
        Scanner nner = new Scanner(System.in);
        String in = nner.next();
        File two = new File(in);
        create(one, two);
    }

    private static void create(File source, File dest) throws IOException {
        FileUtils.copyDirectory(source, dest);
    }


    private static void FileWeight() {
        long kb = 1000;
        long mb = kb * 1000;
        long gb = mb * 1000;

        System.out.println("Введите путь до файла: ");
        Scanner in = new Scanner(System.in);
        String way = in.next();
        File openFile = new File(way);
        long weight = openFile.length() / kb;
        if (weight <= kb) {
            System.out.println(weight + " KByte");
        } else if (weight <= mb) {
            long file = weight / 1000;
            System.out.println(file + " MByte");
        } else if (weight <= gb) {
            long file = weight / 1000;
            System.out.println(file + " GByte");
        }
    }

}

