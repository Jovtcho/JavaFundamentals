import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P07FindMissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());
        int[] nums = Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int missingNum = 0;

        if (nums[0] != 1) {
            System.out.println(1);
            return;
        }

        if (nums[num - 2] != num) {
            System.out.println(num);
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int currentNum = nums[i];
            int nextNum = nums[i + 1];

            if ((nextNum - currentNum) == 1) {
                continue;
            }

            missingNum = currentNum + 1;
        }

        System.out.println(missingNum);
    }
}
