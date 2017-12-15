package exceptions;

public class BrokenWeapon extends IllegalStateException {
    private static final String BROKEN_WEAPON_EXCEPTION = "Weapon is broken.";

    public BrokenWeapon() {
        super(BROKEN_WEAPON_EXCEPTION);
    }

    public BrokenWeapon(String message) {
        super(message);
    }
}
