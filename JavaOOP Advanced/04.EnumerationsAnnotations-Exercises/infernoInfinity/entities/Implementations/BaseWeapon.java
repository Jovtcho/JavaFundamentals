package infernoInfinity.entities.Implementations;

import infernoInfinity.entities.Interfaces.Weapon;
import infernoInfinity.enumerations.GemType;

public abstract class BaseWeapon implements Weapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int socketsCount;
    private GemType[] gems;

    public BaseWeapon(String name, int minDamage, int maxDamage, int socketsCount) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketsCount = socketsCount;
        this.gems = new GemType[this.socketsCount];
    }

    @Override
    public void addGem(GemType gem, int index) {
        if (gem != null && index >= 0 && index < this.gems.length) {
            this.gems[index] = gem;
        }
    }

    @Override
    public void removeGem(int index) {
        if (index >= 0 && index < this.gems.length) {
            if (this.gems[index] != null) {
                this.gems[index] = null;
            }
        }
    }

    @Override
    public double getItemLevel() {
        int strength = 0;
        int agility = 0;
        int vitality = 0;
        for (GemType gem : gems) {
            if (gem != null) {
                strength += gem.getStrength();
                agility += gem.getAgility();
                vitality += gem.getVitality();
            }
        }
        int totalMinDamage = this.minDamage + 2 * strength + agility;
        int totalMaxDamage = this.maxDamage + 3 * strength + 4 * agility;
        return ((totalMinDamage + totalMaxDamage) / 2D) + strength + agility + vitality;
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Double.compare(this.getItemLevel(), otherWeapon.getItemLevel());
    }

    public String print() {
        return String.format("%s (Item Level: %.1f)", this.toString(), this.getItemLevel());
    }

    @Override
    public String toString() {
        //{weapon's name}: {min damage}-{max damage} Damage, +{points} Strength, +{points} Agility, +{points} Vitality
        int strength = 0;
        int agility = 0;
        int vitality = 0;
        for (GemType gem : gems) {
            if (gem != null) {
                strength += gem.getStrength();
                agility += gem.getAgility();
                vitality += gem.getVitality();
            }
        }
        int totalMinDamage = this.minDamage + 2 * strength + agility;
        int totalMaxDamage = this.maxDamage + 3 * strength + 4 * agility;
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, totalMinDamage, totalMaxDamage, strength, agility, vitality);
    }
}
