import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] names = Arrays.stream(bf.readLine().split("\\s+")).toArray(String[]::new);

        Consumer<String> print = output -> System.out.println(output);

        for (String name : names) {
            print.accept(name);
        }
    }
}
