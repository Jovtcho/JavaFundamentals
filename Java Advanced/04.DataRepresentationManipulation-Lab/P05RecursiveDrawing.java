import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class P05RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(bf.readLine());
        drawLines(linesCount);
    }

    private static void drawLines(int linesCount) {
        if (linesCount == 0) {
            return;
        }

        System.out.println(String.join("", Collections.nCopies(linesCount, "*")));
        drawLines(linesCount - 1);
        System.out.println(String.join("", Collections.nCopies(linesCount, "#")));
    }
}
