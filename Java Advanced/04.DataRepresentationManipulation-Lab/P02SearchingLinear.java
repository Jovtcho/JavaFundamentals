import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P02SearchingLinear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchedElement = Integer.parseInt(br.readLine());
        int index = linearSearch(nums, searchedElement);

        System.out.println(index);
    }

    private static int linearSearch(int[] nums, int searchedElement) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == searchedElement) {
                return i;
            }
        }
        return -1;
    }
}
