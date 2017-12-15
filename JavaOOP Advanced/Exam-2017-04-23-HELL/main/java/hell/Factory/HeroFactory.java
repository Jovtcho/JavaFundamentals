package hell.Factory;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;

public final class HeroFactory {
    private HeroFactory() {
    }

    public static Hero create(String name, String type) {
        Hero hero = null;
        Inventory heroInventory = new HeroInventory();

        switch (type.toLowerCase()) {
            case "barbarian":
                return hero = new Barbarian(name, heroInventory);
            case "assassin":
                return hero = new Assassin(name, heroInventory);
            case "wizard":
                return hero = new Wizard(name, heroInventory);
            default:
                return null;
        }

    }
}
