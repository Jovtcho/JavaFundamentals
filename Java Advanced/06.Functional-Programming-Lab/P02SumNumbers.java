import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = bf.readLine().split(",\\s+");

        Function<String, Integer> parser = strNum -> Integer.parseInt(strNum);
        int sum = 0;

        for (String strNum : strNums) {
            sum += parser.apply(strNum);
        }

        System.out.printf("Count = %d%n", strNums.length);
        System.out.printf("Sum = %d", sum);
    }
}
