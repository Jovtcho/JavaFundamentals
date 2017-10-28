package pizzaCalories;

public class Topping {
    private String type;
    private double weight;

    public Topping(String type, double weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    private void setType(String type) {
        boolean isToppingTypeValid = "meat".equalsIgnoreCase(type) || "veggies".equalsIgnoreCase(type)
                || "cheese".equalsIgnoreCase(type) || "sauce".equalsIgnoreCase(type);
        if (!isToppingTypeValid) {
            throw new IllegalArgumentException(
                    String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(double weight) {
        boolean isToppingWeightValid = 1 <= weight && weight <= 50;
        if (!isToppingWeightValid) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    public double calculateToppingCalories() {
        double totalToppingCalorie = 0.0;
        double currentModifier = 0.0;
        switch (this.type.toLowerCase()) {
            case "meat":
                currentModifier = Modifiers.DEFAULT_MEAT_MODIFIER;
                break;
            case "veggies":
                currentModifier = Modifiers.DEFAULT_VEGGIES_MODIFIER;
                break;
            case "cheese":
                currentModifier = Modifiers.DEFAULT_CHEESE_MODIFIER;
                break;
            case "sauce":
                currentModifier = Modifiers.DEFAULT_SAUCE_MODIFIER;
                break;
            default:
                return totalToppingCalorie;
        }

        totalToppingCalorie = Modifiers.DEFAULT_INGREDIENT_VALUE * this.weight * currentModifier;
        return totalToppingCalorie;
    }
}
