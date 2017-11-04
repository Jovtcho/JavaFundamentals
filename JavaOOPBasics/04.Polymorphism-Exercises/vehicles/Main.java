package vehicles;

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

        int commandsCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandsCount; i++) {
            executeCommand(br, df, car, truck);
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static void executeCommand(BufferedReader br, DecimalFormat df,
                                       Vehicle car, Vehicle truck) throws IOException {

        String[] tokens = br.readLine().split("\\s+");
        String command = tokens[0] + " " + tokens[1];
        double distanceOrFuel = Double.parseDouble(tokens[2]);

        switch (command.toLowerCase()) {
            case "drive car":
                try {
                    car.drive(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Car travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel car":
                car.refuel(distanceOrFuel);   // num is fuel
                break;
            case "drive truck":
                try {
                    truck.drive(distanceOrFuel);   // num is distance
                    System.out.println(String.format("Truck travelled %s km", df.format(distanceOrFuel)));
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "refuel truck":
                truck.refuel(distanceOrFuel);   //num is fuel
                break;
            default:
                break;
        }
    }

    private static Vehicle getTruck(BufferedReader br) throws IOException {
        String[] truckTokens = br.readLine().split("\\s+");
        double fuelQuantityTruck = Double.parseDouble(truckTokens[1]);
        double fuelConsumptionPerKmTruck = Double.parseDouble(truckTokens[2]);
        return new Truck(fuelQuantityTruck, fuelConsumptionPerKmTruck);
    }

    private static Vehicle getCar(BufferedReader br) throws IOException {
        String[] carTokens = br.readLine().split("\\s+");
        double fuelQuantityCar = Double.parseDouble(carTokens[1]);
        double fuelConsumptionPerKmCar = Double.parseDouble(carTokens[2]);
        return new Car(fuelQuantityCar, fuelConsumptionPerKmCar);
    }
}
