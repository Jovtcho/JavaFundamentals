import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02GameOfLife {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 10;
        int count = Integer.valueOf(br.readLine());
        int[][] lifeMatrix = new int[size][size];
        int[][] copyOfLifeMatrix = new int[size][size];

        for (int i = 0; i < count; i++) {
            int row = Integer.valueOf(br.readLine());
            int col = Integer.valueOf(br.readLine());
            lifeMatrix[row][size - 1 - col] = 1;
            copyOfLifeMatrix[row][size - 1 - col] = 1;
        }


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                List<Integer> neighbours = new ArrayList<>();

                int n1 = getNeighbour(lifeMatrix, row - 1, col - 1);
                int n2 = getNeighbour(lifeMatrix, row - 1, col);
                int n3 = getNeighbour(lifeMatrix, row - 1, col + 1);
                int n4 = getNeighbour(lifeMatrix, row, col - 1);
                int n5 = getNeighbour(lifeMatrix, row, col + 1);
                int n6 = getNeighbour(lifeMatrix, row + 1, col - 1);
                int n7 = getNeighbour(lifeMatrix, row + 1, col);
                int n8 = getNeighbour(lifeMatrix, row + 1, col + 1);
                Collections.addAll(neighbours, n1, n2, n3, n4, n5, n6, n7, n8);

                int liveNeighbourCount = 0;
                for (Integer neighbour : neighbours) {
                    if (neighbour == 1) {
                        liveNeighbourCount++;
                    }
                }

                int currentCell = lifeMatrix[row][col];

                if (currentCell == 1) {
                    if (liveNeighbourCount < 2 || liveNeighbourCount > 3) {
                        copyOfLifeMatrix[row][col] = 0;
                    }
                } else {
                    if (liveNeighbourCount == 3) {
                        copyOfLifeMatrix[row][col] = 1;
                    }
                }
            }
        }

        for (int index = 0; index < copyOfLifeMatrix.length; index++) {
            int[] currentRow = copyOfLifeMatrix[index];
            System.out.println(Arrays.toString(currentRow).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static int getNeighbour(int[][] lifeMatrix, int row, int col) {
        int n = 0;
        try {
            return n = lifeMatrix[row][col];
        } catch (Exception e) {
            return n = 0;
        }
    }
}
