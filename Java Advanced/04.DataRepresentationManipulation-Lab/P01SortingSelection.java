import java.util.Arrays;
import java.util.Scanner;

public class P01SortingSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums.length - 1; i++) {
            int minElement = nums[i];

            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                int currentElement = nums[j];

                if (currentElement < minElement) {
                    minElement = currentElement;
                    index = j;
                }
            }

            int temp = nums[i];
            nums[i] = minElement;
            nums[index] = temp;
        }

        System.out.println(Arrays.toString(nums).replaceAll("[\\[\\],]", ""));
    }
}
