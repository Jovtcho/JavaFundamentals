package inferno_demo.factories;

import inferno_demo.models.api.WeaponInterface;

public interface CreateWeapon {
    WeaponInterface create(String name);
}
