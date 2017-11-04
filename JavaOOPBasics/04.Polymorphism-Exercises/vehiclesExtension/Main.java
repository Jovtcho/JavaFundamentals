package vehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.##");

        Vehicle car = getCar(br);
        Vehicle truck = getTruck(br);
        Bus bus = getBus(br);

        int commandsCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandsCount; i++) {
            executeCommand(br, df, car, truck, bus);
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static void executeCommand(BufferedReader br, DecimalFormat df,
                                       Vehicle car, Vehicle truck, Vehicle bus) throws IOException {
        String[] tokens = br.readLine().split("\\s+");
        String command = tokens[0] + " " + tokens[1];
        double distanceOrFuel = Double.parseDouble(tokens[2]);

        switch (command.toLowerCase()) {
            case "drive car":
                try {
                    car.drive(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Car travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel car":
                try {
                    car.refuel(distanceOrFuel);   // num is fuel
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "drive truck":
                try {
                    truck.drive(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Truck travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel truck":
                try {
                    truck.refuel(distanceOrFuel);   //num is fuel
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "drive bus":
                try {
                    bus.driveFull(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Bus travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "driveempty bus":
                try {
                    bus.drive(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Bus travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel bus":
                try {
                    bus.refuel(distanceOrFuel);   //num is fuel
                } catch (IllegalStateException | IllegalArgumentException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            default:
                break;
        }
    }

    private static Bus getBus(BufferedReader br) throws IOException {
        String[] truckTokens = br.readLine().split("\\s+");
        double fuelQuantityBus = Double.parseDouble(truckTokens[1]);
        double fuelConsumptionPerKmBus = Double.parseDouble(truckTokens[2]);
        double tankCapacityBus = Double.parseDouble(truckTokens[3]);
        return new Bus(fuelQuantityBus, fuelConsumptionPerKmBus, tankCapacityBus);
    }

    private static Vehicle getTruck(BufferedReader br) throws IOException {
        String[] truckTokens = br.readLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(truckTokens[1]);
        double fuelConsumptionPerKmTruck = Double.parseDouble(truckTokens[2]);
        double tankCapacityTruck = Double.parseDouble(truckTokens[3]);
        return new Truck(fuelQuantityTruck, fuelConsumptionPerKmTruck, tankCapacityTruck);
    }

    private static Vehicle getCar(BufferedReader br) throws IOException {
        String[] carTokens = br.readLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(carTokens[1]);
        double fuelConsumptionPerKmCar = Double.parseDouble(carTokens[2]);
        double tankCapacityCar = Double.parseDouble(carTokens[3]);
        return new Car(fuelQuantityCar, fuelConsumptionPerKmCar, tankCapacityCar);
    }
}
