import java.util.*;

public class Company {
    protected List<Employee> employees = new ArrayList<Employee>();
    protected int income = 0;

    void hire(Employee employee) {
        employee.setId(employees.size());
        employee.setRandomSalary();
        this.employees.add(employee);

        if (employee instanceof Manager) {
            this.income += ((Manager) employee).companyIncome;
            if (income > 10000000 && income - ((Manager) employee).companyIncome <= 10000000) {
                for (int i = 0; i < this.employees.size() - 1; i++)
                {
                    Employee e = this.employees.get(i);
                    if (e instanceof TopManager)
                    {
                        e.setSalary((int)(e.getMonthSalary() * 2.5));
                    }
                }
            }
        }

        if (employee instanceof TopManager && income > 10000000) {
            employee.setSalary((int)(employee.getMonthSalary() * 2.5));
        }
    }

    void hireAll(ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            this.hire(employees.get(i));
        }
    }

    void fire(int id) {
        if (this.employees.get(id) instanceof Manager) {
            this.income -= ((Manager) this.employees.get(id)).companyIncome;
            if (income <= 10000000 && income + ((Manager) this.employees.get(id)).companyIncome > 10000000) {
                for (int i = 0; i < this.employees.size(); i++)
                {
                    Employee e = this.employees.get(i);
                    if (e instanceof TopManager)
                    {
                        e.setSalary((int)(e.getMonthSalary() / 2.5));
                    }
                }
            }
        }
        this.employees.remove(id);
        /*for (int i = id; i < this.employees.size(); i++) {
            this.employees.get(i).setId(i);
        }*/
    }

    int getIncome() {
        return income;
    }

    List<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> employees = new ArrayList<Employee>(this.employees);
        employees.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
            for (int i = employees.size() - 1; i >= count; i--) {
                employees.remove(i);
            }
        return employees;
    }

    List<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> employees = new ArrayList<Employee>(this.employees);
        employees.sort(Comparator.comparing(Employee::getMonthSalary));
            for (int i = employees.size() - 1; i >= count; i--) {
                employees.remove(i);
            }
        return employees;
    }

    int getEmployeeCount() {
        return this.employees.size();
    }

    void shuffle(){
        Collections.shuffle(this.employees, new Random());
        for (int i = 0; i < getEmployeeCount(); i++){
            this.employees.get(i).setId(i);
        }
    }
}
