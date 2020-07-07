import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        //Task 4.1
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.count);
        System.out.println(sumDigits(2349));

        //Task with *
        char ch = '0'; //от 0 до 9
        int i1 = Character.getNumericValue(ch);
        System.out.println(i1);

    }

    // Task 4.2
    public static Integer sumDigits(Integer number) {
        char a = 0;
        int b = 0;
        int result = 0;
        for (int i = 0; i < Integer.toString(number).length(); i++) {
            a = Integer.toString(number).charAt(i);
            String str = String.valueOf(a);
            b = Integer.parseInt(str);
            result = result + b;
        }
        return result;
    }

}
