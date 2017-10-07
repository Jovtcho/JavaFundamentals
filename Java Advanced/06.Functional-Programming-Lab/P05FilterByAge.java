import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.valueOf(bf.readLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] line = bf.readLine().split(",\\s+");
            String name = line[0];
            int age = Integer.valueOf(line[1]);
            people.put(name, age);
        }

        String condition = bf.readLine();
        Integer age = Integer.valueOf(bf.readLine());
        String format = bf.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(people, tester, printer);
    }

    public static void printFilteredStudent(Map<String, Integer> people,
                                            Predicate<Integer> tester,
                                            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        if ("name age".equals(format)) {
            return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        } else if ("name".equals(format)) {
            return person -> System.out.printf("%s%n", person.getKey());
        } else {
            return person -> System.out.printf("%d%n", person.getValue());
        }
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        if ("younger".equals(condition)) {
            return x -> x < age;
        } else {
            return x -> x >= age;
        }
    }
}
