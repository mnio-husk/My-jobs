package Score;

public class Card extends CalculetScore {

    @Override
    public void putMoney(int money) {
        super.putMoney(money);
    }

    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public void takeMoney(int money) {
        super.takeMoney(money + (money/100));
    }
}
