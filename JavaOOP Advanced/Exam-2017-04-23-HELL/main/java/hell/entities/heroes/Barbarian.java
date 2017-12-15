package hell.entities.heroes;

import hell.entities.enumerations.HeroesType;
import hell.interfaces.Inventory;

public class Barbarian extends BaseHero{
    public Barbarian(String name, Inventory inventory) {
        super(name, HeroesType.BARBARIAN.getStrength(),HeroesType.BARBARIAN.getAgility(),
                HeroesType.BARBARIAN.getIntelligence(), HeroesType.BARBARIAN.getHitPoints(),
                HeroesType.BARBARIAN.getDamage(), inventory);
    }
}
