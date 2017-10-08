import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class P06ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        int divisor = Integer.valueOf(bf.readLine());
        nums.removeIf(num -> num % divisor == 0);
        Collections.reverse(nums);
        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\],]", ""));


      // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      // int[] nums = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
      // int devider = Integer.valueOf(bf.readLine());
      // int[] resultArr = Arrays.stream(nums).filter(num -> num % devider != 0).toArray();
      // for (int index = resultArr.length - 1; index >= 0; index--) {
      //     System.out.print(resultArr[index] + " ");
      // }
    }
}
