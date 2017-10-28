package pizzaCalories;

public class Dough {
    private static final double DEFAULT_DOUGH_VALUE = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;
    //private double calories;

   // public double getCalories() {
   //     return this.calories;
   // }

    public Dough() {
    }

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
        //this.calories = calculateDoughCalories();
    }

    private void setFlourType(String flourType) {
        boolean isFlourTypeValid = "white".equalsIgnoreCase(flourType) || "wholegrain".equalsIgnoreCase(flourType);
        if (!isFlourTypeValid) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType.toLowerCase();
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean isBakingTechniqueValid = "crispy".equalsIgnoreCase(bakingTechnique)
                || "chewy".equalsIgnoreCase(bakingTechnique) || "homemade".equalsIgnoreCase(bakingTechnique);
        if (!isBakingTechniqueValid) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique.toLowerCase();
    }

    private void setWeight(double weight) {
        boolean isDoughWeightValid = 1 <= weight && weight <= 200;
        if (!isDoughWeightValid) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateDoughCalories() {
        double totalDoughCalorie = 0.0;
        double currentFlourTypeModifier = 0.0;
        switch (this.flourType) {
            case "white":
                currentFlourTypeModifier = Modifiers.DEFAULT_WHITE_MODIFIER;
                break;
            case "wholegrain":
                currentFlourTypeModifier = Modifiers.DEFAULT_WHOLEGRAIN_MODIFIER;
                break;
        }

        double currentBakingTechniqueModifier = 0.0;
        switch (this.bakingTechnique) {
            case "crispy":
                currentBakingTechniqueModifier = Modifiers.DEFAULT_CRISPY_MODIFIER;
                break;
            case "chewy":
                currentBakingTechniqueModifier = Modifiers.DEFAULT_CHEWY_MODIFIER;
                break;
            case "homemade":
                currentBakingTechniqueModifier = Modifiers.DEFAULT_HOMEMADE_MODIFIER;
                break;
        }

        totalDoughCalorie = Modifiers.DEFAULT_INGREDIENT_VALUE * this.weight
                * currentFlourTypeModifier * currentBakingTechniqueModifier;

        return totalDoughCalorie;
    }
}
