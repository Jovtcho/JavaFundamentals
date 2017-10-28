package pizzaCalories;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int toppingsCount) {
        this.setName(name);
        toppingsCount = setToppingsCount(toppingsCount);
    }

    public Pizza(String name, Dough dough) {
        this.name = name;
        this.dough = dough;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private void setName(String name) {
        boolean isPizzaNameValid = 0 < name.length() && name.length() <= 15;
        if (!isPizzaNameValid) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private int setToppingsCount(int toppingsCount) {
        boolean isToppingsCountValid = 0 <= toppingsCount && toppingsCount <= 10;
        if (!isToppingsCountValid) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        return toppingsCount;
    }

    private double calculatePizzaCalories() {
        double totalPizzaCalories = 0.0;
        double doughCalories = this.dough.calculateDoughCalories();
        double toppingsCalories = 0.0;
        for (Topping topping : toppings) {
            toppingsCalories += topping.calculateToppingCalories();
        }

        totalPizzaCalories = doughCalories + toppingsCalories;
        return totalPizzaCalories;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("%s - %s", this.name, df.format(this.calculatePizzaCalories()));
    }
}
