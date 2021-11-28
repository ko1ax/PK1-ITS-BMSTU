public class Manager extends Employee{
    int companyIncome = ((int)(Math.random() * 25) + 115) * 1000;
    void setRandomSalary() {
        super.setRandomSalary();
        this.salary += this.companyIncome * 0.05;
    }
}
