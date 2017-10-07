import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01ReverseArrayRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int index = 0;

        reverseArray(nums, index);

        System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));

    }

    private static void reverseArray(int[] nums, int index) {
        if (index == nums.length / 2) {
            return;
        }

        int temp = nums[index];
        nums[index] = nums[nums.length - 1 - index];
        nums[nums.length - 1 - index] = temp;

        reverseArray(nums, index + 1);
    }
}
