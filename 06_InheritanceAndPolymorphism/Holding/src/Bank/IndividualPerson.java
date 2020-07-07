package Bank;

public class IndividualPerson extends Client {
    @Override
    public void putMoney(double money) {
        if (money < 1000) {
            super.putMoney(money - (money / 100));
        } else {
            super.putMoney(money - ((money / 2) / 100));
        }
    }

    @Override
    public void takeMoney(double money) {
        super.takeMoney(money);
    }

    @Override
    public double getScore() {
        return super.getScore();
    }
}
