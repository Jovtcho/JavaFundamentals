import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).toArray(Integer[]::new);

        Function<Integer[], Integer> findMinElementInArr = num -> {
            int minElement = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < minElement) {
                    minElement = nums[i];
                }
            }
            return minElement;
        };

        System.out.println(findMinElementInArr.apply(nums));
    }
}
