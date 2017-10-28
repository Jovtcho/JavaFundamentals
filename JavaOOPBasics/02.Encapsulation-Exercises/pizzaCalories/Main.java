package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split("\\s+");
        String[] nextTokens = {""};
        if ("Dough".equalsIgnoreCase(tokens[0])) {
            String doughType = tokens[1];
            String bakingTechnique = tokens[2];
            double doughWeight = Double.valueOf(tokens[3]);
            Dough dough = null;
            try {
                dough = new Dough(doughType, bakingTechnique, doughWeight);
                System.out.printf("%.2f%n", dough.calculateDoughCalories());
                nextTokens = br.readLine().split("\\s+");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        if ("END".equalsIgnoreCase(nextTokens[0])) {
            return;
        } else if ("Topping".equalsIgnoreCase(nextTokens[0])) {
            String toppingName = nextTokens[1];
            double toppingWeight = Double.valueOf(nextTokens[2]);
            try {
                Topping topping = new Topping(toppingName, toppingWeight);
                System.out.printf("%.2f%n", topping.calculateToppingCalories());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
            return;
        }

        String pizzaName = tokens[1];
        int toppingsCount = Integer.valueOf(tokens[2]);

        try {
            Pizza pizza = new Pizza(pizzaName, toppingsCount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        String[] doughTokens = br.readLine().split("\\s+");
        String doughType = doughTokens[1];
        String bakingTechnique = doughTokens[2];
        double doughWeight = Double.valueOf(doughTokens[3]);

        Dough dough = null;
        try {
            dough = new Dough(doughType, bakingTechnique, doughWeight);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        Pizza pizza = new Pizza(pizzaName, dough);

        while (true) {
            String line = br.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] toppingTokens = line.split("\\s+");
            String toppingName = toppingTokens[1];
            double toppingWeight = Double.valueOf(toppingTokens[2]);
            try {
                Topping topping = new Topping(toppingName, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        System.out.println(pizza.toString());
    }
}

