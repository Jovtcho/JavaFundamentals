import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class P02SumNumbersBiFunc {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(bf.readLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        BiFunction<Integer, Integer, Integer> sumTwoNums = (num1, num2) -> num1 + num2;

        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += sumTwoNums.apply(nums[i], nums[i + 1]);
        }

        if (nums.length % 2 != 0) {
            sum += nums[nums.length - 1];
        }

        System.out.printf("Count = %d%n", nums.length);
        System.out.printf("Sum = %d", sum);
    }
}
