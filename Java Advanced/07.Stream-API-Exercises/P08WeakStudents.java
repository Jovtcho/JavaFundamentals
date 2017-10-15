import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P08WeakStudents {
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
                .filter(filterStudentsWithAtLeastTwoMarksUnderOrEqualToNumber())
                .forEach(s -> System.out.println(s.getKey()));
    }

    private static Predicate<Map.Entry<String, List<Integer>>> filterStudentsWithAtLeastTwoMarksUnderOrEqualToNumber() {
        return s -> {
            List<Integer> grades = s.getValue();
            int count = 0;
            for (Integer grade : grades) {
                if (grade <= 3) {
                    count++;
                }
            }
            if (count >= 2) {
                return true;
            } else {
                return false;
            }
        };
    }
}
