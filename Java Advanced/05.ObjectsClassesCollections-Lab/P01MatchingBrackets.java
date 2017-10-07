import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class P01MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String expression = bf.readLine();

        Deque<Integer> inBracket = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);

            if (ch == '(') {
                inBracket.push(index);
            } else if (ch == ')') {
                int startIndex = inBracket.pop();
                String output = expression.substring(startIndex, index + 1);
                System.out.println(output);
            }
        }

    }
}
