package vehiclesExtension;

public class Bus extends Vehicle {
    Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    public void driveFull(double distance) {
        double neededFuel =
                distance * (this.getFuelConsumptionPerKm() + ConsumptionIncrease.BUS_FUEL_INCREASE);
        double diff = this.getFuelQuantity() - neededFuel;
        if (diff < 0) {
            throw new IllegalStateException(
                    String.format("%s %s", this.getClass().getSimpleName(), Messages.VEHICLE_NEEDS_FUEL));
        }
        this.setFuelQuantity(diff);
    }

    @Override
    public void drive(double distance) {
        double neededFuel = distance * this.getFuelConsumptionPerKm();
        double diff = this.getFuelQuantity() - neededFuel;
        if (diff < 0) {
            throw new IllegalStateException(
                    String.format("%s %s", this.getClass().getSimpleName(), Messages.VEHICLE_NEEDS_FUEL));
        }
        this.setFuelQuantity(diff);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
