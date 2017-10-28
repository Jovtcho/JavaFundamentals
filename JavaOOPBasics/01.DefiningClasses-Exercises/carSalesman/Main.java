package carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int enginesCount = Integer.valueOf(br.readLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int index = 0; index < enginesCount; index++) {
            String[] tokens = br.readLine().split("\\s+");
            String engineModel = tokens[0];
            int power = Integer.valueOf(tokens[1]);

            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(engineModel, power);
            } else if (tokens.length == 3) {
                String token = tokens[2];
                try {
                    int displacement = Integer.valueOf(token);
                    engine = new Engine(engineModel, power, displacement);
                } catch (Exception e) {
                    engine = new Engine(engineModel, power, token);
                }
            } else if (tokens.length == 4) {
                int displacement = Integer.valueOf(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(engineModel, power, displacement, efficiency);
            } else {
                System.out.println("Inavlid input.");
            }

            engines.putIfAbsent(engineModel, engine);
        }

        int carsCount = Integer.valueOf(br.readLine());
        for (int index = 0; index < carsCount; index++) {
            String[] tokens = br.readLine().split("\\s+");
            String carModel = tokens[0];
            String engineModel = tokens[1];

            Car car = null;
            if (tokens.length == 2) {
                car = new Car(carModel, engines.get(engineModel));
            } else if (tokens.length == 3) {
                String token = tokens[2];
                try {
                    int weight = Integer.valueOf(token);
                    car = new Car(carModel, engines.get(engineModel), weight);
                } catch (Exception e) {
                    car = new Car(carModel, engines.get(engineModel), token);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.valueOf(tokens[2]);
                String color = tokens[3];
                car = new Car(carModel, engines.get(engineModel), weight, color);
            } else {
                System.out.println("Inavlid input.");
            }

            System.out.println(car.toString());
        }
    }
}
