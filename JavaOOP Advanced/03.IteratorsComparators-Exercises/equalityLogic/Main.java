package equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(br.readLine());
        Set<Person> peopleTreeSet = new TreeSet<>(new PersonComparator());
        Set<Person> peopleHashSet = new HashSet<>();

        getPeople(br, peopleCount, peopleTreeSet, peopleHashSet);

        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());
    }

    private static void getPeople(BufferedReader br, int peopleCount, Set<Person> peopleTreeSet, Set<Person> peopleHashSet) throws IOException {
        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = br.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new PersonImpl(name, age);
            peopleTreeSet.add(person);
            peopleHashSet.add(person);
        }
    }
}
