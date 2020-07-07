import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        HashMap<String, String> contactsName = new HashMap<>();

        while (true) {
            System.out.println("Выберите действие: +7-поиск по номеру телефона, name -поиск по имени, LIST - все контакты ");
            Scanner in = new Scanner(System.in);
            String enter = in.nextLine();
            String numberPhone = "+";
            String list = "LIST";
            String switchAll;
            char b = enter.charAt(0);
            String plus = String.valueOf(b);


            if (plus.equals(numberPhone)) {
                switchAll = "number";

            } else if (enter.equals(list)) {
                switchAll = "LIST";
            } else {
                switchAll = "name";
            }


            switch (switchAll) {

                case "number":
//                    System.out.println("Введите номер телефона: ");
//                    Scanner in_1 = new Scanner(System.in);
//                    String number = in_1.nextLine();

                    String number = enter.replaceAll("[^0-9]", "");

                    if (contacts.containsKey(number)) {
                        System.out.println(contacts.get(number));
                    } else {
                        System.out.println("Введенного номера телефона нет в ваших контакта, введите его имя");
                        Scanner in_2 = new Scanner(System.in);
                        String name = in_2.nextLine();
                        contacts.put(number, name);
                    }
                    break;

                case "name":
//                    System.out.println("Введите имя: ");
//                    Scanner in_3 = new Scanner(System.in);
//                    String name = in_3.nextLine();
                    String name = enter;
                    if (contacts.containsValue(name)) {
                        for (Map.Entry<String, String> entry : contacts.entrySet()) {
                            contactsName.put(entry.getValue(), entry.getKey());
                        }
                        System.out.println(contactsName.get(name));
                    } else {
                        System.out.println("Введенного имени нет в ваших контакта, введите его номер телефона через +7");
                        Scanner in_4 = new Scanner(System.in);
                        String numberEnter = in_4.nextLine();
                        String numberNew = numberEnter.replaceAll("[^0-9]", "");
                        contacts.put(numberNew, name);
                    }
                    break;

                case "LIST":
                    System.out.println(contacts);
                    break;

            }

        }

    }

}

