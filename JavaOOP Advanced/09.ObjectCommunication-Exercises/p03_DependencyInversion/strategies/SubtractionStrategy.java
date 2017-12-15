package p03_DependencyInversion.strategies;

public class SubtractionStrategy implements Strategy {
    public int Calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
