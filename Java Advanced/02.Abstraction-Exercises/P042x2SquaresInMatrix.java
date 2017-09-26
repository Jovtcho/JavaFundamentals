import java.util.Arrays;
import java.util.Scanner;

public class P042x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //char ch = scanner.nextLine().charAt(0);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsNumber = dimensions[0];
        int colsNumber = dimensions[1];

        char[][] matrix = new char[rowsNumber][colsNumber];

        readMatrix(scanner, matrix);

        int counter = calcCounter(matrix);

        System.out.println(counter);
    }

    private static int calcCounter(char[][] matrix) {
        int counter = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                char firstChar = matrix[row][col];
                char secondChar = matrix[row][col + 1];
                char thirdChar = matrix[row + 1][col];
                char forthChar = matrix[row + 1][col + 1];

                boolean isCharsEquals = firstChar == secondChar && secondChar == thirdChar && thirdChar == forthChar;

                if (isCharsEquals){
                    counter++;
                }
            }
        }

        return counter;
    }

    private static void readMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++) {
                char firstChar = line[col].charAt(0);
                matrix[row][col] = firstChar;
            }
        }
    }
}
