package validationData;

public class Person {
    //FirstName: String
    //LastName: String
    //Age: Integer
    //ToString() - override
    private static final int AGE_BONUS_LIMIT = 30;
    private static final int MINIMUM_NAME_LENGTH = 3;
    private static final int MINIMUM_AGE_VALUE = 1;
    private static final double MINIMUM_SALARY_VALUE = 460.0;


    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age > AGE_BONUS_LIMIT) {
            this.setSalary(this.salary + this.salary * bonus / 100);
        } else {
            this.setSalary(this.salary + this.salary * bonus / 200);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String
                    .format("First name cannot be less than %d symbols", MINIMUM_NAME_LENGTH));
        }
        this.firstName = firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String
                    .format("Last name cannot be less than %d symbols", MINIMUM_NAME_LENGTH));
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < MINIMUM_AGE_VALUE) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary < MINIMUM_SALARY_VALUE) {
            throw new IllegalArgumentException(String
                    .format("Salary cannot be less than %.0f leva", MINIMUM_SALARY_VALUE));
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, this.salary);
    }
}
