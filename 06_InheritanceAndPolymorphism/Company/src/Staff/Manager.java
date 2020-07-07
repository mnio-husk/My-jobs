package Staff;


public class Manager implements Employee {
    private double fixMoney = 30000;
    private double bonus;
    private Company company;



    public Manager(Company company) {
        this.company = company;
        this.bonus = company.getIncome() * 0.05;
    }


    @Override
    public Double getMonthSalary() {
        return fixMoney + bonus;
    }

    @Override
    public String getPosition() {
        return "Manager";
    }
}
