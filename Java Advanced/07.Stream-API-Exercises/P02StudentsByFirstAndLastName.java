import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> names = new LinkedHashSet<>();

        while (true) {
            String line = bf.readLine().trim();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            } else {
                names.add(line);
            }

            if (names.isEmpty()) {
                return;
            }
        }

        names.stream()
                .filter(s -> (s != null && !s.isEmpty()))
                .filter(s -> s.split("\\s+")[0].compareTo(s.split("\\s+")[1]) < 0)
                .forEach(s -> System.out.println(s));
    }
}
