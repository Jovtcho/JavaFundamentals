package rawData;

import java.util.List;

public class Tire {
    private static final int DEFAULT_TIRE_PRESURE = 1;
    private double presure;
    private int age;

    public Tire(double presure, int age) {
        this.presure = presure;
        this.age = age;
    }

    public double getPresure() {
        return this.presure;
    }

    public boolean checkTirePresure(Tire tire) {
        return tire.getPresure() < DEFAULT_TIRE_PRESURE;
    }
}
