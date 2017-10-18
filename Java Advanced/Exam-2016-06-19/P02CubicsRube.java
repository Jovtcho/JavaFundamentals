import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02CubicsRube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //   5
        //   3 2 3 10
        //   -1 -1 -1 0
        //   1 4 0 20
        //   2 2 2 5
        //   Analyze

        int cubeSize = Integer.valueOf(br.readLine());
        long[][][] cube = new long[cubeSize][cubeSize][cubeSize];
        int unchangedElements = 0;
        long sumParticles = 0;

        while (true) {
            String line = br.readLine();
            if ("Analyze".equalsIgnoreCase(line)) {
                break;
            }

            int[] tokens = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int xDim = tokens[0];
            int yDim = tokens[1];
            int zDim = tokens[2];
            int particle = tokens[3];

            boolean isXdimCorrect = 0 <= xDim && xDim < cubeSize;
            boolean isYdimCorrect = 0 <= yDim && yDim < cubeSize;
            boolean isZdimCorrect = 0 <= zDim && zDim < cubeSize;
            boolean isParticleCoordinatesCorrect = isXdimCorrect && isYdimCorrect && isZdimCorrect;

            if (isParticleCoordinatesCorrect) {
                cube[xDim][yDim][zDim] = particle;
            }
        }

        for (int x = 0; x < cubeSize; x++) {
            for (int y = 0; y < cubeSize; y++) {
                for (int z = 0; z < cubeSize; z++) {
                    if (cube[x][y][z] != 0L) {
                        sumParticles += cube[x][y][z];
                    } else {
                        unchangedElements++;
                    }
                }
            }
        }

        System.out.println(sumParticles);
        System.out.println(unchangedElements);
    }
}
