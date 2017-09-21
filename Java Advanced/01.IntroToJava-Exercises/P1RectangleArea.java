import java.util.Scanner;

public class P1RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double sideA = Double.parseDouble(input[0]);
        double sideB = Double.parseDouble(input[1]);

        double area = sideA * sideB;

        System.out.printf("%.2f", area);
    }
}
