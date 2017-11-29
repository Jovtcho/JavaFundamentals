package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;
import inferno_demo.models.impl.Hammer;

public final class CreateHammer implements CreateWeapon {
    private CreateHammer() {
    }

    @Override
    public final WeaponInterface create(String name) {
        return new Hammer(name);
    }
}
