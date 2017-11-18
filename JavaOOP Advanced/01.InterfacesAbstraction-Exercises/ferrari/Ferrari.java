package ferrari;

public class Ferrari implements Car {
    private static final String MODEL_DEFAULT = "488-Spider";
    private static final String BRAKES_DEFAULT = "Brakes!";
    private static final String GAS_PEDAL_DEFAULT = "Zadu6avam sA!";

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.setModel();
        this.setDriver(driver);
    }

    private void setModel() {
        this.model = MODEL_DEFAULT;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String pushBrakes() {
        return BRAKES_DEFAULT;
    }

    @Override
    public String pushGasPedal() {
        return GAS_PEDAL_DEFAULT;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, this.pushBrakes(),
                this.pushGasPedal(), this.driver);
    }
}
