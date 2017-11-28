package infernoInfinity.entities.Implementations;

import infernoInfinity.entities.Interfaces.Weapon;
import infernoInfinity.enumerations.WeaponType;

public class Sword extends BaseWeapon  {
    public Sword(String name) {
        super(name, WeaponType.SWORD.getMinDamage(), WeaponType.SWORD.getMaxDamage(),
                WeaponType.SWORD.getSocketsCount());
    }
}
