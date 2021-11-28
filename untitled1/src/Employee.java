public class Employee {
    protected int id;
    protected int salary;

    Employee() {}
    Employee(Employee employee){
        this.id = employee.id;
        this.salary = employee.salary;
    }

    void setId(int id) {
        this.id = id;
    }
    void setRandomSalary() {
        this.salary = Salary.a[(int)(Math.random()*5)];
    }
    void setSalary(int salary){
        this.salary = salary;
    }

    int getMonthSalary(){
        return this.salary;
    }

    void getInfo() {
        System.out.println("id: " + this.id + ", salary: " + this.salary + ", job: " + this.getClass());
    }
}
