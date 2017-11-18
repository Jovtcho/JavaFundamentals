package p08MilitaryElite.models.implementations;

import p08MilitaryElite.models.interfaces.Private;

public class PrivateImpl extends BaseSoldier implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(String.format(" Salary: %.2f", this.getSalary()));

        return sb.toString();
    }
}
