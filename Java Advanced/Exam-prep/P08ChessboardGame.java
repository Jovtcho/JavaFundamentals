import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

public class P08ChessboardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(br.readLine());
        char[] text = br.readLine().toCharArray();
        List<Integer> blackTeam = new ArrayList<>();
        List<Integer> whiteTeam = new ArrayList<>();

        int counter = Math.min(text.length, size * size);

        for (int index = 0; index < counter; index++) {
            char ch = text[index];
            if (index % 2 == 0) { // black
                if (65 <= (int) ch && (int) ch <= 90) {
                    whiteTeam.add((int) ch);
                    continue;
                }

                blackTeam.add(Character.isLetterOrDigit(ch) ? (int) ch : 0);
            } else { // white
                if (65 <= (int) ch && (int) ch <= 90) {
                    blackTeam.add((int) ch);
                    continue;
                }

                whiteTeam.add(Character.isLetterOrDigit(ch) ? (int) ch : 0);
            }
        }

        int sumBlack = blackTeam.stream().mapToInt(Integer::valueOf).sum();
        int sumWhite = whiteTeam.stream().mapToInt(Integer::valueOf).sum();

        if (sumBlack > sumWhite) {
            System.out.println("The winner is: black team");
            System.out.println(sumBlack - sumWhite);
        } else if (sumWhite > sumBlack) {
            System.out.println("The winner is: white team");
            System.out.println(sumWhite - sumBlack);
        } else {
            System.out.printf("Equal result: %d", sumBlack);
        }

    }
}
