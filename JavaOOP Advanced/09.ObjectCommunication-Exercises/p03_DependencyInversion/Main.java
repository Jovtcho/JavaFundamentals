package p03_DependencyInversion;

import p03_DependencyInversion.strategies.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Strategy strategy = new AdditionStrategy();
        Calculator calculator = new PrimitiveCalculator(strategy);
        int result = 0;

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");

            if ("mode".equalsIgnoreCase(tokens[0])) {
                strategy = getStrategy(tokens[1]);
                if (strategy != null) {
                    calculator.changeStrategy(strategy);
                }
            } else {
                int firstOperand = Integer.parseInt(tokens[0]);
                int secondOperand = Integer.parseInt(tokens[1]);
                result = calculator.performCalculation(firstOperand, secondOperand);
                System.out.println(result);
            }
        }
    }

    private static Strategy getStrategy(String sign) {
        switch (sign) {
            case "+":
                return new AdditionStrategy();
            case "-":
                return new SubtractionStrategy();
            case "*":
                return new MultiplyStrategy();
            case "/":
                return new DivisionStrategy();
        }
        return null;
    }
}
