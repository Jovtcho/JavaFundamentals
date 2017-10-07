import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P06OverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(bf.readLine());

        int[][] intervals = new int[count][2];

        readInput(bf, intervals);
        orderByFirstColumn(intervals);
        orderBySecondColumn(intervals);

        for (int row = 0; row < intervals.length - 1; row++) {
            if (intervals[row][1] >= intervals[row + 1][0]) {
                System.out.println("true");
                return;
            }
        }

        System.out.println("false");
    }

    private static void orderBySecondColumn(int[][] intervals) {
        for (int row = 0; row < intervals.length - 1; row++) {
            if (intervals[row][0] != intervals[row + 1][0]) {
                continue;
            }

            if (intervals[row][1] > intervals[row + 1][1]) {
                int temp = intervals[row][1];
                intervals[row][1] = intervals[row + 1][1];
                intervals[row + 1][1] = temp;
            }
        }
    }

    private static void orderByFirstColumn(int[][] intervals) {
        for (int row = 0; row < intervals.length - 1; row++) {
            int minElement = intervals[row][0];

            int index = row;
            for (int j = row + 1; j < intervals.length; j++) {
                int currentElement = intervals[j][0];

                if (currentElement < minElement) {
                    minElement = currentElement;
                    index = j;
                }
            }

            int temp = intervals[row][0];
            intervals[row][0] = minElement;
            intervals[index][0] = temp;

            temp = intervals[row][1];
            intervals[row][1] = intervals[index][1];
            intervals[index][1] = temp;
        }
    }

    private static void readInput(BufferedReader bf, int[][] intervals) throws IOException {
        for (int i = 0; i < intervals.length; i++) {
            intervals[i] = Arrays.stream(bf.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
