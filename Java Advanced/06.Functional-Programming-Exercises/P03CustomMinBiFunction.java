import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class P03CustomMinBiFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).toArray(Integer[]::new);

        BiFunction<Integer, Integer, Integer> returnMinElementFromTwo = (num1, num2) -> num1 >= num2 ? num2 : num1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = returnMinElementFromTwo.apply(min, nums[i]);
        }

        System.out.println(min);
    }
}
