import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10PlusRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> textLines = new ArrayList<>();
        List<String> copyTextLines = new ArrayList<>();
        readInput(scanner, textLines, copyTextLines);
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int row = 0; row < copyTextLines.size() - 2; row++) {
            char[] firstLine = copyTextLines.get(row).toCharArray();
            char[] secondLine = copyTextLines.get(row + 1).toCharArray();
            char[] thirdLine = copyTextLines.get(row + 2).toCharArray();

            for (int col = 1; col < firstLine.length; col++) {
                if (col + 2 > secondLine.length || col + 1 > thirdLine.length) {
                    break;
                }

                boolean isPlus = firstLine[col] == secondLine[col - 1]
                        && secondLine[col - 1] == secondLine[col]
                        && secondLine[col] == secondLine[col + 1]
                        && secondLine[col + 1] == thirdLine[col];

                if (isPlus) {
                    rows.add(row);
                    cols.add(col);
                    char ch = '\0';
                    StringBuilder sb = new StringBuilder();

                    sb.append(textLines.get(row));
                    sb.setCharAt(col, ch);
                    textLines.set(row, sb.toString());
                    sb.setLength(0);

                    sb.append(textLines.get(row + 1));
                    sb.setCharAt(col - 1, ch);
                    sb.setCharAt(col, ch);
                    sb.setCharAt(col + 1, ch);
                    textLines.set(row + 1, sb.toString());
                    sb.setLength(0);

                    sb.append(textLines.get(row + 2));
                    sb.setCharAt(col, ch);
                    textLines.set(row + 2, sb.toString());
                    sb.setLength(0);
                }
            }
        }

        removeEmptySpaces(textLines);

        for (String line : textLines) {
            System.out.println(line);
        }
    }

    private static void removeEmptySpaces(List<String> textLines) {
        for (int row = 0; row < textLines.size(); row++) {
            String currentLine = textLines.get(row);
            currentLine = currentLine.replaceAll("\0", "");
            textLines.set(row, currentLine);
        }
    }

    private static void readInput(Scanner scanner, List<String> textLines, List<String> copyTextLines) {
        String line = scanner.nextLine();

        while (true) {
            if (line.equals("END")) {
                break;
            }

            textLines.add(line);
            copyTextLines.add(line.toLowerCase());
            line = scanner.nextLine();
        }
    }
}
