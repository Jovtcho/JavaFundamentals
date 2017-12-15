package p03_DependencyInversion.strategies;

public class MultiplyStrategy implements Strategy {

    public int Calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
