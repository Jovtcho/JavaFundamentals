import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] names = Arrays.stream(bf.readLine().split("\\s+")).toArray(String[]::new);

        Consumer<String> appendSirAndPrint = name
                -> System.out.println(new StringBuilder("Sir " + name));

        for (String name : names) {
            appendSirAndPrint.accept(name);
        }
    }
}
