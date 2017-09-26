import java.util.*;

public class P11StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> textLines = new ArrayList<>();
        String[] rotationCommand = scanner.nextLine().split("[()]");
        int degrees = Integer.parseInt(rotationCommand[1]);

        readInput(scanner, textLines);

        String maxLengthString = Collections.max(textLines, Comparator.comparing(s -> s.length()));
        int maxLength = maxLengthString.length();
        int size = textLines.size();
        char[][] matrix = new char[textLines.size()][maxLength];

        convertToRectangleMatrix(textLines, maxLength, matrix);

        if (degrees % 360 == 0) {
            rotateBy360Degrees(maxLength, size, matrix);
        } else if (degrees % 360 == 270) {
            rotateBy270Degrees(maxLength, size, matrix);
        } else if (degrees % 360 == 180) {
            rotateBy180Degrees(maxLength, size, matrix);
        } else if (degrees % 360 == 90) {
            rotateBy90Degrees(maxLength, size, matrix);
        } else {
            System.out.println("Incorrect degrees!");
        }
    }

    private static void rotateBy90Degrees(int maxLength, int size, char[][] matrix) {
        for (int col = 0; col < maxLength; col++) {
            for (int row = size - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void rotateBy180Degrees(int maxLength, int size, char[][] matrix) {
        for (int row = size - 1; row >= 0; row--) {
            for (int col = maxLength - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void rotateBy270Degrees(int maxLength, int size, char[][] matrix) {
        for (int col = maxLength - 1; col >= 0; col--) {
            for (int row = 0; row < size; row++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void rotateBy360Degrees(int maxLength, int size, char[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < maxLength; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void convertToRectangleMatrix(List<String> textLines, int maxLength, char[][] matrix) {
        for (int i = 0; i < textLines.size(); i++) {
            String line = textLines.get(i);
            int emptySpacesLength = maxLength - line.length();
            String emptySpaces = new String(new char[emptySpacesLength]).replace('\0', ' ');
            line = line.concat(emptySpaces);
            textLines.set(i, line);
            char[] lineChars = textLines.get(i).toCharArray();
            matrix[i] = lineChars;
        }
    }

    private static void readInput(Scanner scanner, List<String> textLines) {
        String line = scanner.nextLine();

        while (true) {
            if (line.equals("END")) {
                break;
            }

            textLines.add(line);
            line = scanner.nextLine();
        }
    }
}
