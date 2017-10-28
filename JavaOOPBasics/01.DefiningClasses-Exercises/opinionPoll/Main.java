package opinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.valueOf(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int index = 0; index < personCount; index++) {
            String[] line = br.readLine().split("\\s+");
            String name = line[0];
            int age = Integer.valueOf(line[1]);
            Person currentPerson = new Person(name, age);
            people.add(currentPerson);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
    }
}
