package Score;

public class CalculetScore {
    private int score;

    public void putMoney(int money) {
        this.score = this.score + money;
    }

    public void takeMoney(int money) {
        this.score = this.score - money;
    }

    public int getScore() {
        return this.score;
    }

}
