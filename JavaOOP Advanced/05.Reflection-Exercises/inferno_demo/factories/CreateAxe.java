package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;
import inferno_demo.models.impl.Axe;

public final class CreateAxe implements CreateWeapon {
    private CreateAxe() {
    }

    @Override
    public final WeaponInterface create(String name) {
        return new Axe(name);
    }
}
