import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P01Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] roomSize = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int rowsCount = roomSize[0];
        int colsCount = roomSize[1];
        long[][] room = new long[rowsCount][colsCount];

        while (true) {
            String line = bf.readLine();
            if ("Here We Go".equalsIgnoreCase(line)) {
                break;
            }

            int[] coordinates = Arrays.stream(line.split("\\s+")).mapToInt(Integer::valueOf).toArray();
            int x1 = coordinates[0];
            int y1 = coordinates[1];
            int x2 = coordinates[2];
            int y2 = coordinates[3];

            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    room[row][col]++;
                }
            }
        }

        for (int row = 0; row < room.length; row++) {
            System.out.println(Arrays.toString(room[row]).replaceAll("[\\[\\],]", ""));
        }
    }
}
