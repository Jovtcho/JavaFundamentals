package hell.entities.heroes;

import hell.entities.enumerations.HeroesType;
import hell.interfaces.Inventory;

public class Wizard extends BaseHero{
    public Wizard(String name, Inventory inventory) {
        super(name, HeroesType.WIZARD.getStrength(),HeroesType.WIZARD.getAgility(),
                HeroesType.WIZARD.getIntelligence(), HeroesType.WIZARD.getHitPoints(),
                HeroesType.WIZARD.getDamage(), inventory);
    }
}
