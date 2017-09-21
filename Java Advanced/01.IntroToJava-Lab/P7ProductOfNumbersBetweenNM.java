import java.math.BigDecimal;
import java.util.Scanner;

public class P7ProductOfNumbersBetweenNM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigDecimal result = new BigDecimal("1");
        int counter = n;

        do {
            BigDecimal multiplyer = new BigDecimal(counter);
            result = result.multiply(multiplyer);
            counter++;
        } while (counter <= m);

        System.out.printf("product[%d..%d] = %.0f%n", n, m, result);
    }
}
