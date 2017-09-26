import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[matrixSize][matrixSize];

        readMatrix(scanner, matrix);
        int diagonalsDiff = calcDiagonalsSums(matrix);

        System.out.println(diagonalsDiff);
    }

    private static int calcDiagonalsSums(int[][] matrix) {
        int rightDiagonalSum = 0;
        int leftDiagonalSum = 0;

        for (int index = 0; index < matrix.length; index++) {
            rightDiagonalSum += matrix[index][index];

            leftDiagonalSum += matrix[index][matrix.length - 1 - index];
        }

        int diagonalsDiff = Math.abs(rightDiagonalSum - leftDiagonalSum);

        return diagonalsDiff;
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
    }
}
