import Score.CalculetScore;
import Score.Card;
import Score.Depository;


public class Main {
    public static void main(String[] args) {
        Card object = new Card();
        object.putMoney(500);
        object.takeMoney(200);
        System.out.println(object.getScore());

        Depository score = new Depository();
        score.putMoney(1000);
        score.takeMoney(300);
        System.out.println(score.getScore());

        CalculetScore scoreCard = new CalculetScore();
        System.out.println("Money in the score: " + scoreCard.getScore());
        scoreCard.putMoney(5000);
        scoreCard.takeMoney(2510);
        System.out.println(scoreCard.getScore());


    }
}
