package mankind;

import java.text.DecimalFormat;

public class Worker extends Human {
    private double weekSalary;
    private double hoursPerDay;


    Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(double weekSalary) {
        this.weekSalary = weekSalary;
    }

    private double getHoursPerDay() {
        return this.hoursPerDay;
    }

    private void setHoursPerDay(double hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    private double calculateSalaryPerHour(double weekSalary, double hoursPerDay) {
        return weekSalary / (7 * hoursPerDay);
    }

    @Override
    public String toString() {
        DecimalFormat df= new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Week Salary: ").append(df.format(this.getWeekSalary())).append(System.lineSeparator());
        sb.append("Hours per day: ").append(df.format(this.getHoursPerDay())).append(System.lineSeparator());
        sb.append("Salary per hour: ")
                .append(df.format(calculateSalaryPerHour(this.getWeekSalary(), this.getHoursPerDay())))
                .append(System.lineSeparator());
        return sb.toString();
    }
}