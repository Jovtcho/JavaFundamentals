import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P01TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        // filter - 10 ≤ n ≤ 20
        Predicate<Integer> filter = n -> 10 <= n && n <= 20;

        // only unique numbers
        // only the first 2 elements
        Consumer<Integer> print = n -> System.out.print(n + " ");
        nums.stream()
                .filter(filter)
                .distinct()
                .limit(2)
                .forEach(print);
    }
}
