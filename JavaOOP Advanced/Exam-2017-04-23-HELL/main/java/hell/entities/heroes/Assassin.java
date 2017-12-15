package hell.entities.heroes;

import hell.entities.enumerations.HeroesType;
import hell.interfaces.Inventory;

public class Assassin extends BaseHero {
    public Assassin(String name, Inventory inventory) {
        super(name, HeroesType.ASSASSIN.getStrength(),HeroesType.ASSASSIN.getAgility(),
                HeroesType.ASSASSIN.getIntelligence(), HeroesType.ASSASSIN.getHitPoints(),
                HeroesType.ASSASSIN.getDamage(), inventory);
    }
}
