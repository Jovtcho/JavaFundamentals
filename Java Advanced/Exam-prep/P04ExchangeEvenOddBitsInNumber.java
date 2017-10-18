import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04ExchangeEvenOddBitsInNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.valueOf(br.readLine());

        for (int i = 0; i < 64; i += 2) {
            long maskEven = 1L << i;
            long maskOdd = 1L << i + 1;

            long bitEven = num & maskEven;
            long bitOdd = num & maskOdd;

            if (bitEven != bitOdd) {
                num ^= 1L << i;
                num ^= 1L << i + 1;
            }
        }

        System.out.println(num);
    }
}
