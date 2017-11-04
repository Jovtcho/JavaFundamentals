package vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double fuelQuantity);
}
