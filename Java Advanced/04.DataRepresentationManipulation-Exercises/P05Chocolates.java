import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P05Chocolates {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int packetsCount = Integer.parseInt(bf.readLine());
        int[] chocolatesInPacket = Arrays.stream(bf.readLine().split(", ")).mapToInt(Integer::new).toArray();
        int studentsCount = Integer.parseInt(bf.readLine());
        Arrays.sort(chocolatesInPacket);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < chocolatesInPacket.length + 1 - studentsCount; i++) {
            int[] subArrayFromChocolates = Arrays.copyOfRange(chocolatesInPacket, i, i + studentsCount);
            int currentDiff = Math.abs(subArrayFromChocolates[0] - subArrayFromChocolates[subArrayFromChocolates.length - 1]);

            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        System.out.printf("Min Difference is %d.%n", minDiff);
    }
}
