package carSalesman;

import java.util.Map;

public class Car {
    //“<Model> <Engine> <Weight> <Color> Car’s weight and color are optional
    private static final int DEFAULT_WEGHT_VALUE = -1;
    private static final String DEFAULT_COLOR_VALUE = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT_WEGHT_VALUE;
        this.color = DEFAULT_COLOR_VALUE;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
        this.color = DEFAULT_COLOR_VALUE;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.weight = DEFAULT_WEGHT_VALUE;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.model).append(":").append(System.lineSeparator());
        sb.append(this.engine.toString());
        if (this.weight == -1) {
            sb.append("  Weight: n/a").append(System.lineSeparator());
        } else {
            sb.append("  Weight: ").append(this.weight).append(System.lineSeparator());
        }
        sb.append("  Color: ").append(this.color);
        return sb.toString();
    }
}