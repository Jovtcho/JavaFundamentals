import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P02UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

//        List<String> strings = Arrays.stream(bf.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> strings = Arrays.asList(bf.readLine().split("\\s+"));

        strings.stream()
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.print(s + " "));

    }
}
