public class Main {
    public static void main(String[] args) {
        //Латиница верхний регистр
        System.out.println("Латиница верхний регистр");
        for (char a = '\u0041'; a < '\u005A'; a++)
        {
            int c= a;
            System.out.println(a + ": " + c);
        }
        System.out.println("\nЛатиница нижний регистр ");

        //Латиница нижний регистр
        for (char a = '\u0061'; a < '\u007A'; a++)
        {
            int c= a;
            System.out.println(a + ": " + c);
        }
        System.out.println("\nКириллица верхний регистр");

        //Кириллица верхний регистр
        for (char a = '\u0410'; a < '\u042F'; a++)
        {
            int c= a;
            System.out.println(a + ": " + c);
        }
        System.out.println("\nКириллица нижний регистр");

        //Кириллица нижний регистр
        for(char a = '\u0430'; a <= '\u044f'; a++)
        {
            int c= a;
            System.out.println(a + ": " + c);
        }
    }
}
