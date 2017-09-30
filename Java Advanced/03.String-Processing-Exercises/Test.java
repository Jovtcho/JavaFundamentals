import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.####");
        double num = 10.625000;
        System.out.printf("%.2f%n", num);               //  10.63
        System.out.printf("%d%n", (int) num);           //  10
        System.out.printf("%f%n", num);                 //  10.625000
        System.out.println(num);                        //  10.625
        System.out.println(df.format(num));             //  10.625
    }
}
