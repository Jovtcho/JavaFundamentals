import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P07SaltAndPepper_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(br.readLine());

        while (true) {
            String line = br.readLine();
            if ("end".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String spice = tokens[0];
            int dish = Integer.valueOf(tokens[1]);

            if ("salt".equalsIgnoreCase(spice)) {
                for (int i = 0; i < 64; i += dish) {
                    BigInteger mask = BigInteger.ONE.shiftLeft(i).not();
                    num = num.and(mask);
                }
            } else if ("pepper".equalsIgnoreCase(spice)) {
                for (int i = 0; i < 64; i += dish) {
                    BigInteger mask = BigInteger.ONE.shiftLeft(i);
                    num = num.or(mask);
                }
            } else {
                System.out.println("No such spice!");
            }
        }

        System.out.println(num);
    }
}
