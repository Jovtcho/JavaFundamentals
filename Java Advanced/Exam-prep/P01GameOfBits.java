import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01GameOfBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.valueOf(br.readLine());
        long outputNum = 0L;

        while (true) {
            String command = br.readLine();
            if ("Game Over!".equalsIgnoreCase(command)) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            int mask = 1;
            if ("Odd".equalsIgnoreCase(command)) {
                getBits(num, sb, mask);
            } else if ("Even".equalsIgnoreCase(command)) {
                num = num >> 1;
                getBits(num, sb, mask);
            } else {
                System.out.println("No such command!");
                continue;
            }

            if (sb.length() == 0) {
                sb.append(0);
            }

            num = Long.parseLong(sb.reverse().toString(), 2);
        }

        int bitCount = Long.bitCount(num);
        System.out.printf("%d -> %d", num, bitCount);
    }

    private static void getBits(long num, StringBuilder sb, int mask) {
        while (num > 0) {
            long tempNum = num & mask;
            int bit = tempNum == mask ? 1 : 0;
            sb.append(bit);
            num = num >> 2;
        }
    }
}
