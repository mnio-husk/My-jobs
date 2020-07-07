package Staff;

public class TopManager implements Employee {
    private double fixMoney = 70000;
    private double bonus;
    private double income;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
        this.income = company.getIncome();
        int min = 10000000;
        if (this.income >= min) {
            this.bonus = fixMoney + (fixMoney / 2);
        } else {
            this.bonus = 0;
        }

    }


    @Override
    public Double getMonthSalary() {
        return fixMoney + bonus;
    }

    @Override
    public String getPosition() {
        return "TopManager";
    }
}
