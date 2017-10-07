import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P01BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int numsCount = line[0];
        int numsForPop = line[1];
        int searchedNum = line[2];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] nums = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index < numsCount; index++) {
            stack.push(nums[index]);
        }

        for (int counter = 0; counter < numsForPop; counter++) {
            stack.pop();
        }

        if (stack.contains(searchedNum)) {
            System.out.println("true");
            return;
        }

        int[] stackNumsArr = new int[stack.size()];

        for (int i = 0; i < stackNumsArr.length; i++) {
            stackNumsArr[i] = stack.pop();
        }

        Arrays.sort(stackNumsArr);
        System.out.println(stackNumsArr.length == 0 ? "0" : stackNumsArr[0]);
    }
}
