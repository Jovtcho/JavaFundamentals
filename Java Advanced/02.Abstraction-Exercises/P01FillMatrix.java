import java.util.Scanner;

public class P01FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split(", ");
        int size = Integer.parseInt(commands[0]);
        char command = commands[1].charAt(0);
        int[][] matrix = new int[size][size];

        if (command == 'A') {
            setMatrixPatternA(size, matrix);
        } else if (command == 'B') {
            setMatrixPatternB(size, matrix);
        } else {
            System.out.println("No such command!");
        }

        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void setMatrixPatternB(int size, int[][] matrix) {
        int num = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = num;
                } else {
                    int count = (col + 1) * size;
                    matrix[row][col] = count - row;
                }
                num++;
            }
        }
    }

    private static void setMatrixPatternA(int size, int[][] matrix) {
        int num = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
    }
}
