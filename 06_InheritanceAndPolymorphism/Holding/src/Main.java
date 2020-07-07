import Bank.IndividualPerson;
import Bank.LegalPerson;
import Bank.PhysicPerson;

public class Main {
    public static void main(String[] args) {
        PhysicPerson scorePhysic = new PhysicPerson();
        System.out.println("Счёт физического лица: " + scorePhysic.getScore());
        scorePhysic.putMoney(5000);
        scorePhysic.takeMoney(2561);
        System.out.println("Счёт физического лица: " + scorePhysic.getScore());

        LegalPerson scoreLegal = new LegalPerson();
        System.out.println("Счёт юридического лица: " + scoreLegal.getScore());
        scoreLegal.putMoney(5000);
        scoreLegal.takeMoney(2561);
        System.out.println("Счёт юридического лица: " + scoreLegal.getScore());

        IndividualPerson scoreIndividual = new IndividualPerson();
        System.out.println("Счёт ИП: " + scoreIndividual.getScore());
        scoreIndividual.putMoney(5000);
        System.out.println("Счёт ИП: " + scoreIndividual.getScore());
        scoreIndividual.takeMoney(2561);
        System.out.println("Счёт ИП: " + scoreIndividual.getScore());
    }
}
