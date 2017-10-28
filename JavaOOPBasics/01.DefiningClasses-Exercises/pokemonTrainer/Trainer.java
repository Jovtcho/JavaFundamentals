package pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static final int DEFAULT_BADGE_VALUE = 0;
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = DEFAULT_BADGE_VALUE;
        this.pokemons = new ArrayList<>();
    }

    // public Trainer(String name, int badgesCount, List<Pokemon> pokemons) {
    //     this.name = name;
    //     this.badgesCount = badgesCount;
    //     this.pokemons = pokemons;
    // }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badgesCount, this.pokemons.size());
    }
}
