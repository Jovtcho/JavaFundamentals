import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P04CombinationsCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int elementsNumber = Integer.parseInt(bf.readLine());
        BigInteger num = BigInteger.valueOf(elementsNumber);

        int elementsClass = Integer.parseInt(bf.readLine());
        BigInteger numClass = BigInteger.valueOf(elementsClass);

        int diff = elementsNumber-elementsClass;
        BigInteger diffNumClass = BigInteger.valueOf(diff);

        BigInteger numFactorial = calculateFactorial(num);

        BigInteger diffNumClassFactorial = calculateFactorial(diffNumClass);

        BigInteger classFactorial = calculateFactorial(numClass);

        BigInteger combinations = numFactorial.divide(diffNumClassFactorial.multiply(classFactorial));
        System.out.println(combinations);
    }

    private static BigInteger calculateFactorial(BigInteger num) {
        if (num.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        return num.multiply(calculateFactorial(num.subtract(BigInteger.ONE)));
    }
}
