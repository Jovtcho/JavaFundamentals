import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P05BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> bracketsStack = new ArrayDeque<>();
        Deque<Character> bracketsQueue = new ArrayDeque<>();
        char[] input = bf.readLine().toCharArray();

        for (char ch : input) {
            bracketsStack.push(ch);
            bracketsQueue.addLast(ch);
        }

        boolean isBalancedParentheses = true;

        for (int i = 0; i < input.length; i++) {
            if (bracketsQueue.peek() == '{' && bracketsStack.peek() == '}'
                    || bracketsQueue.peek() == '}' && bracketsStack.peek() == '{') {
                bracketsQueue.poll();
                bracketsStack.pop();
                continue;
            }

            if (bracketsQueue.peek() == '[' && bracketsStack.peek() == ']'
                    || bracketsQueue.peek() == ']' && bracketsStack.peek() == '[') {
                bracketsQueue.poll();
                bracketsStack.pop();
                continue;
            }

            if (bracketsQueue.peek() == '(' && bracketsStack.peek() == ')'
                    || bracketsQueue.peek() == ')' && bracketsStack.peek() == '(') {
                bracketsQueue.poll();
                bracketsStack.pop();
                continue;
            }

            if (bracketsQueue.peek() == ' ' && bracketsStack.peek() == ' ') {
                bracketsQueue.poll();
                bracketsStack.pop();
                continue;
            }

            isBalancedParentheses = false;
            break;
        }

        System.out.println(isBalancedParentheses ? "YES" : "NO");
    }

}
