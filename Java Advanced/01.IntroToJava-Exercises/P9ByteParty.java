import java.util.Arrays;
import java.util.Scanner;

public class P9ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCount = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[numberCount];

        for (int i = 0; i < numberCount; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        String input = scanner.nextLine();

        while (true) {
            if (input.equals("party over")) {
                break;
            }

            int[] commands = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int command = commands[0];
            int pos = commands[1];
            //int mask;

            SetBits(nums, command, pos);

            input = scanner.nextLine();
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void SetBits(int[] nums, int command, int pos) {
        int mask;

        switch (command) {
            case -1:
                mask = 1 << pos;

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] ^ mask;
                }
                break;
            case 0:
                mask = ~(1 << pos);

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] & mask;
                }
                break;
            case 1:
                mask = 1 << pos;

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = nums[i] | mask;
                }
                break;
            default:
                System.out.println("No such command!");
                break;
        }
    }
}
