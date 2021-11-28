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
        this.salary = (int)((Math.random()*2001) + 500)*100;   //изначально я генерировал зарплату из тех 5 вариантов, которые
                                                               //были просто примером
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
