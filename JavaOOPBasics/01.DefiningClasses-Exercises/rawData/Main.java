package rawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Car> cars = new LinkedHashSet<>();
        int carsCount = Integer.valueOf(br.readLine());

        //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
        //<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age>
        for (int i = 0; i < carsCount; i++) {
            String[] tokens = br.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.valueOf(tokens[1]);
            int enginePower = Integer.valueOf(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.valueOf(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            double tire1Presure = Double.valueOf(tokens[5]);
            int tire1Age = Integer.valueOf(tokens[6]);
            Tire tire1 = new Tire(tire1Presure, tire1Age);
            double tire2Presure = Double.valueOf(tokens[7]);
            int tire2Age = Integer.valueOf(tokens[8]);
            Tire tire2 = new Tire(tire1Presure, tire1Age);
            double tire3Presure = Double.valueOf(tokens[9]);
            int tire3Age = Integer.valueOf(tokens[10]);
            Tire tire3 = new Tire(tire1Presure, tire1Age);
            double tire4Presure = Double.valueOf(tokens[7]);
            int tire4Age = Integer.valueOf(tokens[12]);
            Tire tire4 = new Tire(tire1Presure, tire1Age);
            List<Tire> tires = new ArrayList<>();
            Collections.addAll(tires, tire1, tire2, tire3, tire4);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String cargoType = br.readLine();

        if ("fragile".equalsIgnoreCase(cargoType)) {
            cars.stream()
                    .filter(car -> car.getTires().removeIf(tire -> tire.checkTirePresure(tire)))
                    .forEach(car -> System.out.print(car.toString()));
        } else if ("flamable".equalsIgnoreCase(cargoType)) {
            cars.stream()
                    .filter(car -> car.getEngine().checkEnginePower(car.getEngine()))
                    .forEach(car -> System.out.print(car.toString()));
        } else {
            System.out.println("No such command.");
        }

    }
}
