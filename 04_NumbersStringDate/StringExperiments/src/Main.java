public class Main {
    public static void main(String[] args) {
        String text = "Вася заработал 10000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        String vasya = text.substring(text.indexOf(32) + 1, text.indexOf(44));
        String vasya1 = vasya.substring(vasya.indexOf(32));
        String masha = text.substring(text.lastIndexOf(45) + 1);
        System.out.println("Вася заработал: " + vasya1);
        System.out.println("Маша заработала: " + masha);
        String[] money = text.split("\\,\\s+");
        int summ = 0;

        for(int i = 0; i < money.length; ++i) {
            String a = money[i].replaceAll("[^0-9]", "");
            int converter = Integer.parseInt(a);
            summ += converter;
        }

        System.out.println("Общая сумма дохода: " + summ);
    }
}
