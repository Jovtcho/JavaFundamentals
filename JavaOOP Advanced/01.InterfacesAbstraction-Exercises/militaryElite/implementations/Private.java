package militaryElite.implementations;

import militaryElite.interfaces.IPrivate;

public class Private extends Soldier implements IPrivate {
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id> Salary: <salary>
        return String.format("%s Salary: %.2f", super.toString(), this.getSalary());
    }
}
