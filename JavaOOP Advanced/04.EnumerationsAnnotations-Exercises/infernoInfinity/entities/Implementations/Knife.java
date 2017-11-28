package infernoInfinity.entities.Implementations;

import infernoInfinity.enumerations.WeaponType;

public class Knife extends BaseWeapon {
    public Knife(String name) {
        super(name, WeaponType.KNIFE.getMinDamage(), WeaponType.KNIFE.getMaxDamage(),
                WeaponType.KNIFE.getSocketsCount());
    }
}
