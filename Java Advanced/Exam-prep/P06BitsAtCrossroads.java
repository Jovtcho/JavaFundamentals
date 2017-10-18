import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P06BitsAtCrossroads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(br.readLine());
        int[][] matrix = new int[size][size];
        int crossRoadCounter = 0;

        while (true) {
            String line = br.readLine();
            if ("end".equalsIgnoreCase(line)) {
                break;
            }

            String[] point = line.split("\\s+");
            int pointRow = Integer.valueOf(point[0]);
            int pointCol = Integer.valueOf(point[1]);

            if (pointRow <= pointCol) {
                for (int row = 0; row < size - (pointCol - pointRow); row++) {
                    if (matrix[row][pointCol - pointRow + row] == 1) {
                        crossRoadCounter++;
                        continue;
                    }

                    matrix[row][pointCol - pointRow + row] = 1;
                }

                if ((pointRow + pointCol) <= (size - 1)) {
                    for (int row = 0; row <= pointRow + pointCol; row++) {
                        if (matrix[row][pointRow + pointCol - row] == 1) {
                            crossRoadCounter++;
                            continue;
                        }

                        matrix[row][pointRow + pointCol - row] = 1;
                    }
                } else {
                    int counterCol = 0;
                    for (int row = (pointRow + pointCol + 1 - size); row < size; row++) {
                        if (matrix[row][size - 1 - counterCol] == 1) {
                            crossRoadCounter++;
                        }

                        matrix[row][size - 1 - counterCol] = 1;
                        counterCol++;
                    }
                }
            } else {
                int counterCol = 0;
                for (int row = pointRow - pointCol; row < size; row++) {
                    if (matrix[row][counterCol] == 1) {
                        crossRoadCounter++;
                    }

                    matrix[row][counterCol] = 1;
                    counterCol++;
                }

                if ((pointRow) + pointCol <= (size - 1)) {
                    for (int row = 0; row <= pointRow + pointCol; row++) {
                        if (matrix[row][pointRow + pointCol - row] == 1) {
                            crossRoadCounter++;
                            continue;
                        }

                        matrix[row][pointRow + pointCol - row] = 1;
                    }
                } else {
                    counterCol = 0;
                    for (int row = (pointRow + pointCol + 1 - size); row < size; row++) {
                        if (matrix[row][size - 1 - counterCol] == 1) {
                            crossRoadCounter++;
                        }

                        matrix[row][size - 1 - counterCol] = 1;
                        counterCol++;
                    }
                }
            }
        }

        for (int row = 0; row < size; row++) {
            //System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\],]", ""));
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
            }

            String numStr = sb.reverse().toString();
            System.out.println(Long.valueOf(numStr, 2));
        }

        System.out.println(crossRoadCounter);
    }
}
