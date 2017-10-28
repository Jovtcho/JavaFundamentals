package pokemonTrainer;

public class Pokemon {
    private static final int DEFAULT_REDUCE_HEALTH_VALUE = 10;
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth() {
        this.health -= 10;
    }
}
