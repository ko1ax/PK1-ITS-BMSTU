import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TODO: Когда подходил к завершению кода, задумался, а компании деньги же все сотрудники приносят, верно?
//TODO: Но тогда это крайне упрощает задачу. Так что пусть только менеджеры приносят, согласно тому, как я изначально понял ТЗ.
//TODO: Но если такой вариант не устраивает, отпишите мне, я подправлю.

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < 180; i++)
        {
            Operator operator = new Operator();
            employees.add(operator);
        }
        for (int i = 0; i < 80; i++)
        {
            Manager manager = new Manager();
            employees.add(manager);
        }
        for (int i = 0; i < 10; i++)
        {
            TopManager topManager = new TopManager();
            employees.add(topManager);
        }

        company.hireAll(employees);
        company.shuffle();  //чтоб повеселее было

        System.out.println("Company Income: " +company.getIncome());
        System.out.println();
        ArrayList<Employee> top = (ArrayList<Employee>)(company.getTopSalaryStaff(15));
        for (int i = 0; i < 15; i++)
        {
            top.get(i).getInfo();
        }
        System.out.println();
        ArrayList<Employee> lowest = (ArrayList<Employee>)(company.getLowestSalaryStaff(30));
        for (int i = 0; i < 30; i++)
        {
            lowest.get(i).getInfo();
        }

        int eCount = company.getEmployeeCount() / 2;
        for (int i = 0; i < eCount; i++)
        {
            company.fire((int)(Math.random() * company.getEmployeeCount()));
        }

        System.out.println("Company Income: " +company.getIncome());
        System.out.println();
        top = (ArrayList<Employee>)(company.getTopSalaryStaff(15));
        for (int i = 0; i < 15; i++)
        {
            top.get(i).getInfo();
        }
        System.out.println();
        lowest = (ArrayList<Employee>)(company.getLowestSalaryStaff(30));
        for (int i = 0; i < 30; i++)
        {
            lowest.get(i).getInfo();
        }
    }

}