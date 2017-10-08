import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P09CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> evenNums = nums.stream().filter(num -> num % 2 == 0)
                .sorted((num1, num2) -> num1.compareTo(num2)).collect(Collectors.toList());

        List<Integer> oddNums = nums.stream().filter(num -> num % 2 != 0)
                .sorted((num1, num2) -> num1.compareTo(num2)).collect(Collectors.toList());

        nums.clear();
        nums.addAll(evenNums);
        nums.addAll(oddNums);

        System.out.println(Arrays.toString(nums.toArray()).replaceAll("[\\[\\],]",""));
    }
}
