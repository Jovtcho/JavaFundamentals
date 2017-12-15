package rpg_lab;

import rpg_lab.interfaces.RandomProvider;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience, List<Weapon> possibleLoot) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = possibleLoot;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public Weapon giveWeapon(RandomProvider random) {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        int index = random.nextInt(this.possibleLoot.size());
        return this.possibleLoot.get(index);
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
