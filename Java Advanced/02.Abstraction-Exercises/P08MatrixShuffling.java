import java.util.Arrays;
import java.util.Scanner;

public class P08MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rowsNumber = dimensions[0];
        int colsNumber = dimensions[1];

        String[][] matrix = new String[rowsNumber][colsNumber];

        readMatrix(scanner, matrix);

        String input = scanner.nextLine();

        while (true) {
            if (input.equals("END")) {
                break;
            }

            String[] commands = input.split("\\s+");
            boolean isCommandsLengthCorrect = commands.length == 5;

            if (!isCommandsLengthCorrect) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = commands[0];
            boolean isCommandCorrect = command.equals("swap");

            if (!isCommandCorrect) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            int firstRowIndex = Integer.parseInt(commands[1]);
            int firstColIndex = Integer.parseInt(commands[2]);
            int secondRowIndex = Integer.parseInt(commands[3]);
            int secondColIndex = Integer.parseInt(commands[4]);

            boolean isFirstIndexesCorrect = 0 <= firstRowIndex && firstRowIndex < rowsNumber
                    && 0 <= firstColIndex && firstColIndex < colsNumber;
            boolean isSecondIndexesCorrect = 0 <= secondRowIndex && secondRowIndex < rowsNumber
                    && 0 <= secondColIndex && secondColIndex < colsNumber;

            if (!isFirstIndexesCorrect || !isSecondIndexesCorrect) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String tempStr = matrix[firstRowIndex][firstColIndex];
            matrix[firstRowIndex][firstColIndex] = matrix[secondRowIndex][secondColIndex];
            matrix[secondRowIndex][secondColIndex] = tempStr;

            for (int row = 0; row < matrix.length; row++) {
                System.out.println(String.join(" ", matrix[row]));
            }

            input = scanner.nextLine();
        }

        System.out.println();
    }

    private static void readMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }
    }
}
