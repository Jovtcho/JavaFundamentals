import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(bf.readLine().split(",\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        nums.removeIf(num -> num % 2 != 0);
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\]]", ""));

        nums.sort((num1, num2) -> num1.compareTo(num2));
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\]]", ""));
    }
}

