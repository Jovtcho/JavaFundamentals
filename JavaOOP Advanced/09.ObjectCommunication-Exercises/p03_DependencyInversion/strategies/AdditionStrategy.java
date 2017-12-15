package p03_DependencyInversion.strategies;

public class AdditionStrategy implements Strategy{

    public int Calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
}
