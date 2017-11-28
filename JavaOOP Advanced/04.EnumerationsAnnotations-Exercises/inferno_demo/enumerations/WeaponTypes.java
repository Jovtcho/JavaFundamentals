package inferno_demo.enumerations;

public enum WeaponTypes {
    AXE(5, 10, 4),
    SWORD(4, 6, 3),
    KNIFE(3, 4, 2),
    HAMMER(10,20,30);

    private int minDamage;
    private int maxDamage;
    private int sockets;

    WeaponTypes(int minDamage, int maxDamage, int sockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = sockets;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getSockets() {
        return this.sockets;
    }
}
