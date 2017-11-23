package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(br.readLine());
        Set<Person> peopleByName = new TreeSet<>(new PersonComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new PersonComparatorByAge());

        getPeople(br, peopleCount, peopleByName, peopleByAge);
        System.out.println(printPeople(peopleByName));
        System.out.println(printPeople(peopleByAge));
    }

    private static String printPeople(Set<Person> peopleByName) {
        StringBuilder sb = new StringBuilder();
        for (Person person : peopleByName) {
            sb.append(person.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private static void getPeople(BufferedReader br, int peopleCount, Set<Person> peopleByName, Set<Person> peopleByAge) throws IOException {
        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new PersonImpl(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);
        }
    }
}
