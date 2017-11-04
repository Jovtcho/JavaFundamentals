package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Animal> animals = new LinkedHashMap<>();

        while (true) {
            String animalType = br.readLine();
            if ("Beast!".equalsIgnoreCase(animalType)) {
                break;
            }

            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            Animal animal = null;
            try {
                switch (animalType.toLowerCase()) {
                    case "animal":
                        animal = new Animal(name, age, gender);
                        break;
                    case "cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "kitten":
                        animal = new Kitten(name, age, gender);
                        break;
                    case "tomcat":
                        animal = new Tomcat(name, age, gender);
                        break;
                }

                if (animal == null) {
                    System.out.println(ErrorMessages.INVALID_INPUT);
                    return;
                }

                System.out.println(animal.toString());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

        }
    }
}
