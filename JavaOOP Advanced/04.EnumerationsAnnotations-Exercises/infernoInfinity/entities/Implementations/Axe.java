package infernoInfinity.entities.Implementations;

import infernoInfinity.enumerations.WeaponType;

public class Axe extends BaseWeapon {
    public Axe(String name) {
        super(name, WeaponType.AXE.getMinDamage(), WeaponType.AXE.getMaxDamage(),
                WeaponType.AXE.getSocketsCount());
    }
}
