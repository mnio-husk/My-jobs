package Score;

import java.util.Calendar;
import java.util.Date;

public class Depository extends CalculetScore {
    private Date start;
    private Date end;

    @Override
    public void putMoney(int money) {
        super.putMoney(money);
        Calendar date = Calendar.getInstance();
        date.add(Calendar.MONTH, 1);
        this.end = date.getTime();

    }

    @Override
    public void takeMoney(int money) {
        Date date = new Date();
        this.start = date;
        if (this.start.after(end)) {
            super.takeMoney(money);
        } else {
            System.out.println("Вы не можете снять деньги, так как ещё не прошёл месяц");
            System.out.println("Дата когда последний раз положили деньги " + this.start);
            System.out.println("Дата, когда можно снять деньги " + this.end);
        }
    }

    @Override
    public int getScore() {
        return super.getScore();
    }
}
