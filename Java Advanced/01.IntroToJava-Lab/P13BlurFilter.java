import java.util.Arrays;
import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scanner.nextLine());
        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsNumber = dimentions[0];
        int colsNumber = dimentions[1];

        long[][] matrix = new long[rowsNumber][colsNumber];

        for (int row = 0; row < rowsNumber; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToLong(Long::parseLong).toArray();
        }

        int[] blurCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int blurX = blurCoordinates[0];
        int blurY = blurCoordinates[1];

        for (int row = blurX - 1; row <= blurX + 1; row++) {
            for (int col = blurY - 1; col <= blurY + 1; col++) {
                try {
                    matrix[row][col] += blurAmount;
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        for (int row = 0; row < rowsNumber; row++) {
            for (int col = 0; col < colsNumber; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
            //System.out.println(matrix[row].toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
