import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P07ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();

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
            List<Integer> grades = tokens.subList(2, tokens.size()).stream()
                    .map(Integer::valueOf).collect(Collectors.toList());
            students.put(studentName, grades);
        }

        students.entrySet().stream()
                .filter(s -> s.getValue().stream().anyMatch(m -> m == 6))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
