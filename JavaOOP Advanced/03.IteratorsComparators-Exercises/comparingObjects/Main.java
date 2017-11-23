package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            Person person = new PersonImpl(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);
        }

        System.out.println(getStatistics(br, people));
    }

    private static String getStatistics(BufferedReader br, List<Person> people) throws IOException {
        int index = Integer.parseInt(br.readLine());
        int equalCount = 0;

        if (index >= 0 && index < people.size()) {
            Person referencePerson = people.get(index);
            for (Person person : people) {
                if (referencePerson.compareTo(person) == 0) {
                    equalCount++;
                }
            }
        }

        return (equalCount != 0
                ? String.format("%d %d %d%n", equalCount, people.size() - equalCount, people.size())
                : "No matches");
    }
}
