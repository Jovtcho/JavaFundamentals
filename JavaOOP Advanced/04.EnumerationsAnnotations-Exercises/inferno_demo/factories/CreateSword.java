package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;
import inferno_demo.models.impl.Sword;

public final class CreateSword implements CreateWeapon{
    private CreateSword() {
    }

    @Override
    public WeaponInterface create(String name) {
        return new Sword(name);
    }
}
