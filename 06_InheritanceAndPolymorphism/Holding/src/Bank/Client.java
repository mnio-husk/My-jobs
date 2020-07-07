package Bank;

public abstract class Client {
    private double score;

    public void putMoney(double money) {
        this.score = this.score + money;
    }

    public void takeMoney(double money) {
        this.score = this.score - money;
    }

    public double getScore() {
        return this.score;
    }
}
