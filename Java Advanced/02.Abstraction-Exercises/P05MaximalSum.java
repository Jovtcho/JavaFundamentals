import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P05MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsNumber = dimensions[0];
        int colsNumber = dimensions[1];

        int[][] matrix = new int[rowsNumber][colsNumber];

        readMatrix(scanner, matrix);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = calcCurrentSum(matrix, row, col);

                if (sum > maxSum) {
                    maxSum = sum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        printMaxSumMatrix(matrix, maxSum, rowIndex, colIndex);
    }

    private static void printMaxSumMatrix(int[][] matrix, int maxSum, int rowIndex, int colIndex) {
        System.out.printf("Sum = %d%n", maxSum);

        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int calcCurrentSum(int[][] matrix, int row, int col) {
        int sum = 0;

        int[] forSum = {matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]};
        sum += IntStream.of(forSum).sum();
        forSum = new int[]{matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]};
        sum += IntStream.of(forSum).sum();
        forSum = new int[]{matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]};
        sum += IntStream.of(forSum).sum();

        return sum;
    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = line;
        }
    }
}
