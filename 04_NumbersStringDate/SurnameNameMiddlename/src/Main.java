import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int a = 0;
        Scanner in = new Scanner(System.in);

//        while (a == 0)
//            try {
//                System.out.print("Введите фамилию имя и отчество: ");
//
//                String all = in.nextLine();
//
//                String surName = all.substring(0, all.indexOf(' '));
//                String name = all.substring(all.indexOf(' ') + 1, all.lastIndexOf(' '));
//                String middleName = all.substring(all.lastIndexOf(' ') + 1);
//
//                System.out.println("Фамилия: " + surName + "\n" +
//                        "Имя: " + name + "\n" +
//                        "Отчество: " + middleName);
//                a++;
//            } catch (Exception e) {
//                System.out.println("Неверная форма ввода");
//                System.out.println("Пример ввода: Попов Михаил Владимирович");
//            }

        //Task 4.5.3
        int p = 0;
        while (p == 0)
            try {
                System.out.print("Введите фамилию имя и отчество: ");

                String all = in.nextLine();
                String[] b = all.split("\\s");

                System.out.println("Фамилия: " + b[0] + "\n" +
                        "Имя: " + b[1] + "\n" +
                        "Отчество: " + b[2]);
                p++;
            } catch (Exception e) {
                System.out.println("Неверная форма ввода");
                System.out.println("Пример ввода: Попов Михаил Владимирович");
            }

    }

}

