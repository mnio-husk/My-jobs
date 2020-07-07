package Bank;

public class LegalPerson extends Client {
    @Override
    public void putMoney(double money) {
        super.putMoney(money);
    }

    @Override
    public void takeMoney(double money) {
        super.takeMoney(money + (money / 100));
    }

    @Override
    public double getScore() {
        return super.getScore();
    }
}
