import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner enter = new Scanner(System.in);


//        while (true) {
//            System.out.println("Выберите одно из действий:  LIST ||" + " ADD || " + " EDIT || " + " DELETE ");
//            String output = enter.nextLine();
//            output.trim();
//            String[] plus = output.split("\\s");
//
//            if (plus[0].equals("LIST")) {
//                for (String outputScreen : list) {
//                    System.out.println(outputScreen);
//                }
//            }
//
//            if (plus[0].equals("ADD") && plus.length > 2) {
//                int number = Integer.parseInt(plus[1]);
//                if (list.size() >= number) {
//                    list.add(Integer.parseInt(plus[1]), plus[2]);
//                } else if (list.size() < number) {
//                    list.add(plus[2]);
//                }
//            }
//
//            if (plus[0].equals("ADD") && plus.length <= 2) {
//                list.add(plus[1]);
//            }
//
//            if (plus[0].equals("EDIT") && plus.length > 2) {
//                int number = Integer.parseInt(plus[1]) - 1;
//                if (list.size() >= number) {
//                    list.remove(number);
//                    list.add(number, plus[2]);
//                }
//            }
//
//            if (plus[0].equals("DELETE")) {
//                int number = Integer.parseInt(plus[1]) - 1;
//                list.remove(number);
//            }
//        }

        while (true) {
            System.out.println("Выберите одно из действий:  LIST ||" + " ADD || " + " EDIT || " + " DELETE ");
            String output = enter.nextLine();
            output.trim();
            String[] plus = output.split("\\s");

            switch (plus[0]) {

                case "LIST":
                    for (String outputScreen : list) {
                        System.out.println(outputScreen);
                    }
                    break;

                case "ADD":
                    if (plus.length > 2) {
                        int number = Integer.parseInt(plus[1]) - 1;
                        if (list.size() >= number) {
                            list.add(number, plus[2]);
                        } else if (list.size() < number) {
                            list.add(plus[2]);
                        }
                    }

                    if (plus[0].equals("ADD") && plus.length <= 2) {
                        list.add(plus[1]);
                    }
                    break;

                case "EDIT":
                    int number = Integer.parseInt(plus[1]) - 1;
                    if (list.size() >= number) {
                        list.remove(number);
                        list.add(number, plus[2]);
                    }
                    break;

                case "DELETE":
                    int numberDelete = Integer.parseInt(plus[1]) - 1;
                    list.remove(numberDelete);
                    break;
            }
        }
    }
}



