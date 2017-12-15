package hell.entities.enumerations;

public enum HeroesType {

    BARBARIAN(90, 25, 10, 350, 150),
    ASSASSIN(25, 100, 15, 150, 300),
    WIZARD(25, 25, 100, 100, 250);

    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;

    HeroesType(int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
    }

    public long getStrength() {
        return this.strength;
    }

    public long getAgility() {
        return this.agility;
    }

    public long getIntelligence() {
        return this.intelligence;
    }

    public long getHitPoints() {
        return this.hitPoints;
    }

    public long getDamage() {
        return this.damage;
    }
}
