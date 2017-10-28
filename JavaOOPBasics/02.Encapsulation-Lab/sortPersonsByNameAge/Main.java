package sortPersonsByNameAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int index = 0; index < peopleCount; index++) {
            String[] tokens = br.readLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        Collections.sort(people, (Person person1, Person person2) -> {
            int compareValueByFirstName = person1.getFirstName().compareTo(person2.getFirstName());

            if (compareValueByFirstName != 0) {
                return person1.getFirstName().compareTo(person2.getFirstName());
            }

            return Integer.compare(person1.getAge(), person2.getAge());
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
