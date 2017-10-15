import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Sara Mills smills@gmail.com
        // Andrew Gibson agibson@abv.bg

        Map<String, String> students = new LinkedHashMap<>();

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
            String email = tokens.get(2);
            students.put(studentName, email);
        }

        students.entrySet().stream()
                .filter(s -> s.getValue().endsWith("@gmail.com"))
                .forEach(s -> System.out.println(s.getKey()));
    }
}
