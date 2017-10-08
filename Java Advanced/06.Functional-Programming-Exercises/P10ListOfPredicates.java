import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int upperLimit = Integer.valueOf(bf.readLine());
        List<Integer> divisors = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<Predicate<Integer>> predicates = new ArrayList<>();
        generatePredicates(divisors, predicates);
        List<Integer> divided = new ArrayList<>();

        for (int number = 1; number <= upperLimit; number++) {
            boolean isDevided = true;
            for (Predicate<Integer> predicate : predicates) {
                if (!predicate.test(number)) {
                    isDevided = false;
                    break;
                }
            }

            if (isDevided) {
                divided.add(number);
            }
        }

        System.out.println(Arrays.toString(divided.toArray()).replaceAll("[\\[\\],]", ""));
    }

    private static void generatePredicates(List<Integer> divisors, List<Predicate<Integer>> predicates) {
        List<Integer> divisorsSortedDesc = divisors.stream().sorted((num1, num2) -> num2.compareTo(num1))
                .collect(Collectors.toList());

        for (Integer divisor : divisorsSortedDesc) {
            Predicate<Integer> testIfDevided = x -> x % divisor == 0;
            predicates.add(testIfDevided);
        }
    }
}
