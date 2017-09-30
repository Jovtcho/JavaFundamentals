import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        long factorialNum = calculateFactorial(num);

        System.out.println(factorialNum);
    }

    private static long calculateFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * calculateFactorial(num - 1);
    }
}
