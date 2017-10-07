import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class P02NestedLoopsRecursion {
    public static int numberOfLoopd;
    public static int[] loops;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numberOfLoopd = Integer.parseInt(bf.readLine());
        loops = new int[numberOfLoopd];

        nestedLoops(0);
    }

    public static void nestedLoops(int currentLoop) {
        if (currentLoop == numberOfLoopd) {
            printLoop();
            return;
        }

        for (int i = 1; i <= numberOfLoopd; i++) {
            loops[currentLoop] = i;
            nestedLoops(currentLoop + 1);
        }
    }

    private static void printLoop() {
        System.out.println(Arrays.toString(loops).replaceAll("[\\[\\],]",""));
    }
}
