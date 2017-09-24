import java.util.Scanner;

public class P01CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        double triangleArea = CalculateTriangleArea(base, height);

        System.out.printf("Area = %.2f", triangleArea);
    }

    public static double CalculateTriangleArea(double base, double height) {
        double triangleArea = base * height / 2;

        return triangleArea;
    }
}
