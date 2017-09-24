import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int rowCount = matrixDimensions[0];
        int colCount = matrixDimensions[1];

        int[][] matrix = new int[rowCount][colCount];

        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split(", ");

            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(currentRow[col]);
            }
        }

        int sum = getSumMatrixElements(matrix);

        System.out.println(rowCount);
        System.out.println(colCount);
        System.out.println(sum);
    }

    public static int getSumMatrixElements(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sum += matrix[row][col];
            }

            //int[] currentRow = matrix[row];
            //sum += IntStream.of(currentRow).sum();
        }

        return sum;
    }
}
