package infernoInfinity.Factories;

import infernoInfinity.entities.Implementations.Axe;
import infernoInfinity.entities.Implementations.Knife;
import infernoInfinity.entities.Implementations.Sword;
import infernoInfinity.entities.Interfaces.Weapon;

import java.util.List;

public class WeaponFactory {

    public static Weapon createWeapon(List<String> tokens) {
        String weaponType = tokens.remove(0);
        Weapon weapon = null;
        switch (weaponType.toLowerCase()) {
            case "axe":
                return weapon = new Axe(tokens.get(0));
            case "sword":
                return weapon = new Sword(tokens.get(0));
            case "knife":
                return weapon = new Knife(tokens.get(0));
            default:
                return null;
        }
    }
}
