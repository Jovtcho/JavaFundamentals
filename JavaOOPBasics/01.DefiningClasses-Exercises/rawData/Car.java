package rawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public String toString() {
        return String.format("%s%n", this.model);
    }
}
