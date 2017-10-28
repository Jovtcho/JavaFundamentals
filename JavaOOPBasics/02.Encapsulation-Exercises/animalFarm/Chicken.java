package animalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;
    private double productPerDay;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
        this.productPerDay = calculateProductPerDay();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (0 > age || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (0 <= this.age && this.age < 6) {
            return 2;
        } else if (6 <= this.age && this.age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, df.format(this.productPerDay));
    }
}
