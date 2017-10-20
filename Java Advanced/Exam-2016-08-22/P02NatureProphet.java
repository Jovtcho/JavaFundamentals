import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P02NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] garden = new int[rows][cols];

        while (true) {
            String line = br.readLine();
            if ("Bloom Bloom Plow".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            int rowIndex = Integer.parseInt(tokens[0]);
            int colIndex = Integer.parseInt(tokens[1]);

            for (int row = 0; row < rows; row++) {
                garden[row][colIndex]++;
            }

            for (int col = 0; col < cols; col++) {
                garden[rowIndex][col]++;
            }

            garden[rowIndex][colIndex]--;
        }

        for (int[] row : garden) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}
