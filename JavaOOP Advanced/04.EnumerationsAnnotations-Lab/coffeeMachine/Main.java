package coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            String input = br.readLine();
            if ("END".equalsIgnoreCase(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0]);
            } else {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }

        Iterable<Coffee> coffees = coffeeMachine.coffeesSold();
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
