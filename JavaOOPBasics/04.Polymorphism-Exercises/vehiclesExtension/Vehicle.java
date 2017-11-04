package vehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;
    private double tankCapacity;

    Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException(Messages.FUEL_NEGATIVE_VALUE_WARNING);
        }
        this.fuelQuantity = fuelQuantity;
    }

    public abstract void drive(double distance);

    public void driveFull(double distance) {

    }

    public void refuel(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException(Messages.FUEL_NEGATIVE_VALUE_WARNING);
        }
        if ((this.getFuelQuantity() + fuelQuantity) > this.tankCapacity) {
            throw new IllegalArgumentException(Messages.TANK_OVERLOADED_WARNING);
        }
        this.fuelQuantity += fuelQuantity;

    }
}
