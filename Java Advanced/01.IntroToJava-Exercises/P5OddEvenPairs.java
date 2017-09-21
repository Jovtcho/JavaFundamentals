import java.util.Arrays;
import java.util.Scanner;

public class P5OddEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

//        String[] input = scanner.nextLine().split("\\s+");
//        int[] nums = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        if (nums.length % 2 == 0) {
            for (int i = 0; i < nums.length; i += 2) {
                int firstNum = nums[i];
                int secondNum = nums[i + 1];

                if (firstNum % 2 == 0 && secondNum % 2 == 0) {
                    System.out.printf("%d, %d -> both are even%n", firstNum, secondNum);
                } else if (firstNum % 2 == 1 && secondNum % 2 == 1) {
                    System.out.printf("%d, %d -> both are odd%n", firstNum, secondNum);
                } else {
                    System.out.printf("%d, %d -> different%n", firstNum, secondNum);
                }
            }
        } else {
            System.out.println("invalid length");
        }
    }
}
