import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> email = new ArrayList<>();
        Scanner enter = new Scanner(System.in);

        while (true) {
            System.out.print("Ваши действия: LIST-вывести список emails, ADD - добавить email в список: ");
            String output = enter.next();
            switch (output) {
                case "LIST":
                    for (String all : email) {
                        System.out.println(all);
                    }
                    break;

                case "ADD":
                    boolean a = true;
                    while (a == true) {
                        System.out.print("Введите email, который необходимо внести в список: ");
                        Scanner enterEmail = new Scanner(System.in);
                        String enterline = enterEmail.next();
                        String control = "@.";
                        String all = enterline.replaceAll("[^@ - .]", "");
                        if (all.equals(control)) {
                            email.add(enterline);
                            a = false;
                        } else
                            System.out.println("Совершена ошибка, попробуйте ввести email заново");
                    }
                    break;
            }
        }
    }

}

