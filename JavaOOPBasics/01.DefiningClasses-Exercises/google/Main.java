package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();

        while (true) {
            String line = br.readLine();
            if ("End".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String object = tokens[1].toLowerCase();

            Person person = new Person(personName);
            switch (object) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.valueOf(tokens[4]);

                    if (people.containsKey(personName)) {
                        person = people.get(personName);
                    }

                    Person.Company company = person.new Company(companyName, department, salary);
                    person.setCompany(company);
                    people.put(personName, person);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    if (people.containsKey(personName)) {
                        person = people.get(personName);
                    }

                    Person.Pokemon pokemon = person.new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    people.put(personName, person);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    if (people.containsKey(personName)) {
                        person = people.get(personName);
                    }

                    Person.Parent parent = person.new Parent(parentName, parentBirthday);
                    person.addParent(parent);
                    people.put(personName, person);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    if (people.containsKey(personName)) {
                        person = people.get(personName);
                    }

                    Person.Child child = person.new Child(childName, childBirthday);
                    person.addChild(child);
                    people.put(personName, person);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.valueOf(tokens[3]);

                    if (people.containsKey(personName)) {
                        person = people.get(personName);
                    }

                    Person.Car car = person.new Car(carModel, carSpeed);
                    person.setCar(car);
                    people.put(personName, person);
                    break;
                default:
                    System.out.println("No such object.");
                    break;
            }
        }

        String searechedPerson = br.readLine();
        Person person = people.get(searechedPerson);
        System.out.print(person.toString());
    }
}
