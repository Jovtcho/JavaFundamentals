package speedRacing;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer and distanceTraveled
    private static final int DEFAULT_DISTANCE_VALUE = 0;

    private String model;
    private double fuel;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double fuel, double fuelCostPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = DEFAULT_DISTANCE_VALUE;
    }

    public void drive(int distance) {
        double fuelNeeded = distance * fuelCostPerKm;
        if (this.fuel >= fuelNeeded) {
            this.fuel -= fuelNeeded;
            this.distanceTraveled += distance;
            return;
        }

        System.out.println("Insufficient fuel for the drive");
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }
}
