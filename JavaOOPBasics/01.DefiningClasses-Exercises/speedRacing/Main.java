package speedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int carCount = Integer.valueOf(br.readLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int index = 0; index < carCount; index++) {
            //AudiA4 23 0.3
            String[] tokens = br.readLine().split("\\s+");
            String modelCar = tokens[0];
            double fuel = Double.valueOf(tokens[1]);
            double fuelCostPerKm = Double.valueOf(tokens[2]);
            Car car = new Car(modelCar, fuel, fuelCostPerKm);

            cars.putIfAbsent(modelCar, car);
        }

        while (true) {
            String line = br.readLine();
            if ("End".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String modelCar = tokens[1];
            int distance = Integer.valueOf(tokens[2]);

            Car currentCar = cars.get(modelCar);
            currentCar.drive(distance);
            cars.put(modelCar, currentCar);
        }

        cars.values().forEach(System.out::println);
    }
}
