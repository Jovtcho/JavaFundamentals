package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;
import inferno_demo.models.impl.Knife;

public final class CreateKnife implements CreateWeapon {
    private CreateKnife() {
    }

    @Override
    public WeaponInterface create(String name) {
        return new Knife(name);
    }
}
