import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P8GetFirstOddEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] input = scanner.nextLine().split("\\s+");
        int elementsCount = Integer.parseInt(input[1]);
        String command = input[2];

        List<Integer> outputNums = getNumbers(command, nums);

        if (elementsCount >= outputNums.size()) {
            System.out.println(outputNums.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        } else {
            List<Integer> oddNums = outputNums.subList(0, elementsCount);
            System.out.println(oddNums.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }

        boolean test = -11 % 2 == 1;
        System.out.println(test);

    }


    public static List<Integer> getNumbers(String command, int[] nums) {
        List<Integer> outputNums = new ArrayList<>();

        if (command.equals("odd")) {
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (currentNum % 2 != 0) {
                    outputNums.add(currentNum);
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (currentNum % 2 == 0) {
                    outputNums.add(currentNum);
                }
            }
        }

        return outputNums;
    }
}
