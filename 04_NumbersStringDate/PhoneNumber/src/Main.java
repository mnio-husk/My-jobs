import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = 0;
        while (k == 0) {
            System.out.println("Введите номер телефона: ");
            String number = in.nextLine();
            String all = number.replaceAll("[^0-9]", "");

            if (all.length() == 11) {
                String area1 = all.substring(1, 4);
                String area2 = all.substring(4, 7);
                String area3 = all.substring(7, 9);
                String area4 = all.substring(9, 11);
                System.out.println("+7 " + area1 + " " + area2 + "-" + area3 + "-" + area4);
                k++;
            } else if (all.length() == 10) {
                String area1 = all.substring(0, 3);
                String area2 = all.substring(3, 6);
                String area3 = all.substring(6, 8);
                String area4 = all.substring(8, 10);
                System.out.println("+7 " + area1 + " " + area2 + "-" + area3 + "-" + area4);
                k++;
            } else {
                System.out.println("Данный номер телефона введен не верно, повторите ввод заново.");
            }
        }
    }
}
