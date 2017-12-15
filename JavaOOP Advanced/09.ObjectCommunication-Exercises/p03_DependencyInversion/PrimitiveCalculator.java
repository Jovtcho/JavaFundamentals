package p03_DependencyInversion;

import p03_DependencyInversion.strategies.Strategy;

public class PrimitiveCalculator implements Calculator{
    private Strategy strategy;

    public PrimitiveCalculator(Strategy strategy) {
        changeStrategy(strategy);
    }


    @Override
    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.Calculate(firstOperand, secondOperand);
    }
}
