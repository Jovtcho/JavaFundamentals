import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P03BinarySearchRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int searchedElement = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int index = binarySearch(nums, left, right, searchedElement);

        System.out.println(index);
    }

    public static int binarySearch(int[] nums, int left, int right, int searchedElement) {
        if (left <= right) {
            int middle = (left + right) / 2;

            if (searchedElement < nums[middle]) {
                return binarySearch(nums, left, middle - 1, searchedElement);
            } else if (searchedElement > nums[middle]) {
                return binarySearch(nums, middle + 1, right, searchedElement);
            } else {
                return middle;
            }
        }

        return -1;
    }
}
