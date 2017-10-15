import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(bf.readLine().split("\\s+"));
        Set<Character> letters = new HashSet<>();

        Arrays.stream(bf.readLine().split("\\s+"))
                .map(s -> s.toUpperCase().charAt(0))
                .forEach(c -> letters.add(c));

        Optional<String> firstName = names.stream()
                .filter(s -> letters.contains(s.charAt(0)))
                .sorted()
                .findFirst();

        System.out.println(firstName.isPresent() ? firstName.get() : "No match");
    }
}
