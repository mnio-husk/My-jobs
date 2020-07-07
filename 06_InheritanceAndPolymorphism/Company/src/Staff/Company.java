package Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private Double income;

    private ArrayList<Employee> staff = new ArrayList<>();

    public Company(double income) {
        this.income = income;
    }


    public void hire(Employee position) {
        staff.add(position);
    }

    public void hireAll(List<Employee> name) {
        staff.addAll(name);
    }

    public void fire(int number) {
        for (int i = 0; i < number; i++) {
            double random = Math.random() * (staff.size() - 1);
            int randomIndex = (int) (Math.round(random));
            staff.remove(randomIndex);
        }
    }

    public ArrayList<Employee> getStaff() {
        for (Employee in : staff) {
            System.out.println(in.getMonthSalary());
        }
        return staff;
    }


    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(staff, (o1, o2) -> o1.getMonthSalary().compareTo(o2.getMonthSalary()));
        if (staff.size() >= count) {
            for (int i = 0; i < count; i++) {
                int number = i + 1;
                System.out.println(number + "." + staff.get(i).getMonthSalary() + " руб.");
            }
        } else {
            for (int i = 0; i < staff.size(); i++) {
                int number = i + 1;
                System.out.println(number + "." + staff.get(i).getMonthSalary() + " руб");
            }
        }
        return staff;

    }

    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(staff, Collections.reverseOrder((o1, o2) -> o1.getMonthSalary().compareTo(o2.getMonthSalary())));
        if (staff.size() >= count) {
            for (int i = 0; i < count; i++) {
                int number = i + 1;
                System.out.println(number + "." + staff.get(i).getMonthSalary() + " руб.");
            }
        } else {
            for (int i = 0; i < staff.size(); i++) {
                int number = i + 1;
                System.out.println(number + "." + staff.get(i).getMonthSalary() + " руб");
            }
        }
        return staff;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
    
}


