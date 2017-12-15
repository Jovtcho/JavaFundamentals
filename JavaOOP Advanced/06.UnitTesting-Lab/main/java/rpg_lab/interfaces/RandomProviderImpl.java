package rpg_lab.interfaces;

import java.util.Random;

public class RandomProviderImpl implements RandomProvider {
    private Random random;

    public RandomProviderImpl() {
        this.random = new Random();
    }

    public int nextInt(int limit) {
        return this.random.nextInt(limit);
    }
}
