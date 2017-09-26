import java.util.Arrays;
import java.util.Scanner;

public class P06SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rowsNumber = dimensions[0];
        int colsNumber = dimensions[1];

        String[][] matrix = new String[rowsNumber][colsNumber];

        readMatrix(scanner, matrix);

        // int maxLen = 1;
        // String maxLenElement = "";

        // for (int row = 0; row < matrix.length; row++) {
        //     String firstElement = matrix[row][0];
        //     int len = 1;

        //     for (int col = 1; col < matrix[row].length; col++) {
        //         String currentElement = matrix[row][col];

        //         if (firstElement.equals(currentElement)) {
        //             len++;

        //             if (len >= maxLen) {
        //                 maxLen = len;
        //                 maxLenElement = currentElement;
        //             }

        //         } else {
        //             firstElement = currentElement;
        //             len = 1;
        //         }
        //     }
        // }

        //  System.out.println(maxLen);
        //  System.out.println(maxLenElement);

        int maxLenCol = 1;
        String maxLenElementCol = "";

        for (int col = 0; col < colsNumber; col++) {
            String firstElement = matrix[0][col];
            int len = 1;

            for (int row = 1; row < rowsNumber; row++) {
                String currentElement = matrix[row][col];

                if (firstElement.equals(currentElement)) {
                    len++;

                    if (len >= maxLenCol) {
                        maxLenCol = len;
                        maxLenElementCol = currentElement;
                    }
                } else {
                    firstElement = currentElement;
                    len = 1;
                }
            }
        }

        int maxLenDiag = 1;
        String maxLenElementDiag = "";

        for (int col = 0; col < colsNumber; col++) {
            String firstElement = matrix[0][col];
            int len = 1;

            for (int row = 1; row < rowsNumber; row++) {
                try {
                    String currentElement = matrix[row][col + row];

                    if (firstElement.equals(currentElement)) {
                        len++;

                        if (len >= maxLenDiag) {
                            maxLenDiag = len;
                            maxLenElementDiag = currentElement;
                        }
                    } else {
                        firstElement = currentElement;
                        len = 1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        int maxLenToPrint = 0;
        String maxLenElementToPrint = "";

        if (maxLenCol > maxLenDiag) {
            maxLenToPrint = maxLenCol;
            maxLenElementToPrint = maxLenElementCol;
        } else {
            maxLenToPrint = maxLenDiag;
            maxLenElementToPrint = maxLenElementDiag;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < maxLenToPrint; i++) {
            sb.append(maxLenElementToPrint + ", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());


    }

    private static void readMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }
    }
}
