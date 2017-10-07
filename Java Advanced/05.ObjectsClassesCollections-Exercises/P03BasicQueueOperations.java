import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P03BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numsCount = line[0];
        int numsForPop = line[1];
        int searchedNum = line[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] nums = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numsCount; index++) {
            queue.add(nums[index]);
        }

        for (int counter = 0; counter < numsForPop; counter++) {
            queue.poll();
        }

        if (queue.contains(searchedNum)) {
            System.out.println("true");
            return;
        }

        if (queue.size() == 0) {
            System.out.println("0");
            return;
        }

        int minElement = queue.peek();

        while (queue.size() > 0) {
            int currentElement = queue.poll();
            if (currentElement <= minElement) {
                minElement = currentElement;
            }
        }

        System.out.println(minElement);
    }
}
