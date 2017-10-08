import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public class P08FindSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).toArray(Integer[]::new);

        Function<Integer[], Integer> getMinElementIndex = num -> {
            int minElement = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= minElement) {
                    minElement = nums[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(getMinElementIndex.apply(nums));
    }
}
