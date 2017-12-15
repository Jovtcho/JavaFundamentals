package P04_DetailPrinter;

public class Engineer extends Employee {
    private int iq;

    public Engineer(String name, int iq) {
        super(name);
        this.iq = iq;
    }

    @Override
    public String toString() {
        return super.toString() + ", IQ: " + this.iq;
    }
}
