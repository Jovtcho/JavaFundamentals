import java.math.BigDecimal;
import java.util.Scanner;

public class P3EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wurstPriceLevaPerKilo = 1.2;
        double wurstQuantity = Double.parseDouble(scanner.nextLine());
        BigDecimal exchangeRate = new BigDecimal("4210500000000");

        BigDecimal wurtsPriceLeva = new BigDecimal(wurstPriceLevaPerKilo * wurstQuantity);

        BigDecimal wurstPriceMarks = exchangeRate.multiply(wurtsPriceLeva);

        System.out.printf("%.2f marks", wurstPriceMarks);
    }
}
