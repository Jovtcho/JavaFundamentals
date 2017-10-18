import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P01BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger(br.readLine());

        for (int i = 0; i < 63; i++) {
            int shiftLeft = 61 - i;
            if (shiftLeft < 0) {
                break;
            }

            BigInteger firstBitMask = BigInteger.ONE.shiftLeft(shiftLeft + 2);
            BigInteger secondBitMask = BigInteger.ONE.shiftLeft(shiftLeft + 1);
            BigInteger thirdBitMask = BigInteger.ONE.shiftLeft(shiftLeft);

            BigInteger checkFirstBit = num.and(firstBitMask);
            BigInteger checkSecondBit = num.and(secondBitMask);
            BigInteger checkThirdBit = num.and(thirdBitMask);

            boolean isFirstBitOne = checkFirstBit.equals(firstBitMask);
            boolean isSecondBitOne = checkSecondBit.equals(secondBitMask);
            boolean isThirdBitOne = checkThirdBit.equals(thirdBitMask);
            boolean areAllThreeBitsOne = isFirstBitOne && isSecondBitOne && isThirdBitOne;
            boolean areAllThreeBitsZero = !isFirstBitOne && !isSecondBitOne && !isThirdBitOne;

            if (areAllThreeBitsOne) {
                num = num.xor(firstBitMask);
                num = num.xor(secondBitMask);
                num = num.xor(thirdBitMask);
                i += 2;
            } else if (areAllThreeBitsZero) {
                num = num.or(firstBitMask);
                num = num.or(secondBitMask);
                num = num.or(thirdBitMask);
                i += 2;
            }
        }

        System.out.println(num);
    }
}
