package p03_DependencyInversion;

import p03_DependencyInversion.strategies.Strategy;

public interface Calculator {
    void changeStrategy(Strategy strategy);

    int performCalculation(int firstOperand, int secondOperand);
}
