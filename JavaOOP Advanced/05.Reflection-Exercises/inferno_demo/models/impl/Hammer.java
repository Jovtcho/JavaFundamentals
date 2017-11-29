package inferno_demo.models.impl;

import inferno_demo.enumerations.WeaponTypes;

public class Hammer extends Weapon {
    public Hammer(String name) {
        super(name, WeaponTypes.HAMMER.getMinDamage(), WeaponTypes.HAMMER.getMaxDamage(), WeaponTypes.HAMMER.getSockets());
    }
}
