import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSum2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rowNumber = matrixDimensions[0];
        int colNumber = matrixDimensions[1];

        int[][] matrix = new int[rowNumber][colNumber];

        for (int row = 0; row < rowNumber; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[row] = line;
        }

        int biggestSum = 0;
        int firstRowIndex = 0;
        int firstColIndex = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > biggestSum) {
                    biggestSum = currentSum;
                    firstRowIndex = row;
                    firstColIndex = col;
                }
            }
        }

        for (int row = firstRowIndex; row < firstRowIndex + 2; row++) {
            for (int col = firstColIndex; col < firstColIndex + 2; col++) {
                int currentMatrixElement = matrix[row][col];
                System.out.print(currentMatrixElement + " ");
            }
            System.out.println();
        }

        System.out.println(biggestSum);
    }
}
