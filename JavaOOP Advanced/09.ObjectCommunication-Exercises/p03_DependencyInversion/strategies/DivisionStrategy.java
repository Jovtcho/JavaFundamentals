package p03_DependencyInversion.strategies;

public class DivisionStrategy implements Strategy {

    public int Calculate(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
