import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - EEEE");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, 10, 26);
        Date date = new Date();
        Date your = calendar.getTime();

        for (int i = 0; date.compareTo(your) > 0; ++i) {
            System.out.println(i + dateFormat.format(your));
            calendar.add(Calendar.YEAR, 1);
            your = calendar.getTime();
        }

    }
}
