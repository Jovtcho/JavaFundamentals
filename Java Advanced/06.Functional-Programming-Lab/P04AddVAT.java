
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double[] nums = Arrays.stream(bf.readLine().split(", "))
                .mapToDouble(Double::parseDouble).toArray();

        Function<Double, Double> addVat = num -> num * 1.2;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = addVat.apply(nums[i]);
        }

        System.out.println("Prices with VAT:");
        for (double num : nums) {
            String outputNum = String.format("%.2f", num).replace('.',',');
            System.out.println(outputNum);
        }
    }
}
