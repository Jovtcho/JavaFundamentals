import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P02MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int commandsCount = Integer.parseInt(bf.readLine());
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Integer> maxNums = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < commandsCount; i++) {
            int[] input = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int command = input[0];
            int num = 0;

            if (input.length > 1) {
                num = input[1];
            }

            if (command == 1) {
                nums.push(num);

                if (num >= max) {
                    max = num;
                    maxNums.push(max);
                }
            } else if (command == 2) {
                int numForRemove = nums.pop();

                if (numForRemove == max) {
                    maxNums.pop();
                    if (maxNums.size() > 0) {
                        max = maxNums.peek();
                    } else {
                        max = 0;
                    }
                }
            } else if (command == 3) {
                System.out.println(max);
            } else {
                System.out.println("No such command!");
            }
        }
    }

}
