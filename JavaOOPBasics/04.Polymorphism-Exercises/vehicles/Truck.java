package vehicles;

public class Truck extends Vehicle {
    Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    public void drive(double distance) {
        double neededFuel =
                distance * (this.getFuelConsumptionPerKm() + SummerConsumptionIncrease.TRUCK_FUEL_INCREASE);
        double diff = this.getFuelQuantity() - neededFuel;
        if (diff < 0) {
            throw new IllegalStateException(
                    String.format("%s %s", this.getClass().getSimpleName(), Messages.VEHICLE_NEEDS_FUEL));
        }
        this.setFuelQuantity(diff);
    }

    @Override
    public void refuel(double fuelQuantity) {
        this.setFuelQuantity(this.getFuelQuantity() + 0.95 * fuelQuantity);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
