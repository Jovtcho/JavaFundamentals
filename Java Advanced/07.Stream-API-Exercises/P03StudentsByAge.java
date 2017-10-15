import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();

        while (true) {
            String line = bf.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            List<String> tokens = Arrays.stream(line.split("\\s+"))
                    .filter(s -> (s != null && !s.isEmpty())).collect(Collectors.toList());
            if (tokens.isEmpty()) {
                return;
            }

            String studentName = tokens.get(0) + " " + tokens.get(1);
            int age = Integer.valueOf(tokens.get(2));
            students.put(studentName, age);
        }

        //Map<String, String> filteredStudents =
        students.entrySet().stream()
                .filter(s -> (18 <= s.getValue() && s.getValue() <= 24))
                .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));
        // .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println();
    }
}
