import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rowsNumber = dimentions[0];
        int colsNumber = dimentions[1];
        String[][] matrix = new String[rowsNumber][colsNumber];

        generatePalindromeMatrix(rowsNumber, colsNumber, matrix);

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(String.join(" ",matrix[row]));
        }
    }

    private static void generatePalindromeMatrix(int rowsNumber, int colsNumber, String[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < rowsNumber; row++) {
            char symmetric = (char) (97 + row);
            sb.append(symmetric);
            sb.append(symmetric);

            for (int col = 0; col < colsNumber; col++) {
                char middle = (char) (97 + col + row);
                sb.insert(1, middle);
                matrix[row][col] = sb.toString();
                sb.deleteCharAt(1);
            }

            sb.setLength(0);
        }
    }
}
