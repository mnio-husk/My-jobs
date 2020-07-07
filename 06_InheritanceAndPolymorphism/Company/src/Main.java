import Staff.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company(10000000.0);
        List <Employee> list = new ArrayList();
        for (int i = 0; i < 180; i++){
            list.add(new Operator());
        }
        for (int i = 0; i < 80; i++ ){
            list.add(new Manager(company));
        }
        for (int i = 0; i < 10; i++ ){
            list.add(new TopManager(company));
        }
        company.hireAll(list);
        System.out.println(company.getLowestSalaryStaff(10));
        System.out.println(company.getTopSalaryStaff(30));
        company.fire(135);
        System.out.println(company.getLowestSalaryStaff(10));
        System.out.println(company.getTopSalaryStaff(30));
    }
}
