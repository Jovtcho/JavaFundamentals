import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P05WaveBits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.valueOf(br.readLine());
        String numToBits = Long.toBinaryString(num);
        int longestBitsSequence = 0;
        int longestStartIndex = 0;
        int currentSequence = 1;

        for (int index = 0; index <= 61; index++) {
            boolean isBit1Up = ((num >> index) & 1) == 1;
            boolean isBit2Down = ((num >> index + 1) & 1) == 0;
            boolean isBit3Up = ((num >> index + 2) & 1) == 1;
            boolean isWave = isBit1Up && isBit2Down && isBit3Up;

            if (isWave) {
                currentSequence += 2;
                if (currentSequence > longestBitsSequence) {
                    longestBitsSequence = currentSequence;
                    longestStartIndex = index + 2;
                }
                index++;
            } else {
                currentSequence = 1;
            }
        }

        int longestEndIndex = longestStartIndex - longestBitsSequence + 1;
        long outputNumber = 0L;

        for (int i = 63; i >= 0; i--) {
            boolean inShouldBeDeletedRange = i <= longestStartIndex && i >= longestEndIndex;
            if (inShouldBeDeletedRange) {
                outputNumber >>= 1;
            } else {
                long currentBit = num & (1L << i);
                outputNumber |= currentBit;
            }
        }

        System.out.println(longestBitsSequence == 0 ? "No waves found!" : outputNumber);
    }
}
