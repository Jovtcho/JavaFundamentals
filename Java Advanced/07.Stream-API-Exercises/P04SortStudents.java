import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();

        while (true) {
            String line = bf.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            if (line == null || line.isEmpty()) {
                continue;
            }

            students.add(line);
        }

        students.stream()
                .sorted((s1, s2) -> {
                    if (s1.split("\\s+")[1].compareTo(s2.split("\\s+")[1]) == 0) {
                        return s2.split("\\s+")[0].compareTo(s1.split("\\s+")[0]);
                    } else {
                        return s1.split("\\s+")[1].compareTo(s2.split("\\s+")[1]);
                    }
                })
                .forEach(s -> System.out.println(s));
    }
}
