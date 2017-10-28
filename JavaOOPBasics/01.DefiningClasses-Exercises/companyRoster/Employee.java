package companyRoster;

public class Employee {
    private static final String DEFAULT_EMAIL_VALUE = "n/a";
    private static final int DEFAULT_AGE_VALUE = -1;
    //: name, salary, position, department, email and age

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL_VALUE;
        this.age = DEFAULT_AGE_VALUE;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        //Pesho 120.00 pesho@abv.bg 28
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
