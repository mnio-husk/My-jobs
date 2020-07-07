package Staff;

public class Operator implements Employee {
    private double fixMoney = 30000;

    @Override
    public Double getMonthSalary() {
        return fixMoney;
    }

    @Override
    public String getPosition() {
        return "Operator";
    }
}
