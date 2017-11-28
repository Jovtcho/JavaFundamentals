package warningLevels;

public enum Importance {
    LOW, NORMAL, MEDIUM, HIGH;

    @Override
    public String toString() {
        return super.name();
    }
}
