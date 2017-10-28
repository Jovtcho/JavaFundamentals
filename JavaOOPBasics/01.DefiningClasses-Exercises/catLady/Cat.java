package catLady;

public abstract class Cat {
    private String name;
    private String type;

    protected Cat(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.type, this.name);
    }
}
