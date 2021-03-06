import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class P10GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Person> personList = new ArrayList<>();

        while (true) {
            String line = bf.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            Integer group = Integer.valueOf(tokens[2]);

            Person person = new Person(name, group);
            personList.add(person);
        }

        //personList.stream().map(person ->)

        Map<Integer, List<Person>> result = personList.stream()
                .collect(Collectors.groupingBy(p -> p.getGroup()));

        personList.stream()
                .collect(Collectors.groupingBy(p -> p.getGroup()))
                .entrySet()
                .stream()
                .forEach(g -> {
                    System.out.printf("%d - ", g.getKey());
                    System.out.println(g.getValue()
                            .stream()
                            //.map(p -> p.getName())
                            .map(Person::getName)
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
                });
    }
}
