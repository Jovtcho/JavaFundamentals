import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class P03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] words = bf.readLine().split("\\s+");
        List<String> firstChUpperCaseWords = new LinkedList<>();

        Predicate<String> isFirstChUpper = (word) -> word.charAt(0) == word.toUpperCase().charAt(0);

        for (String word : words) {
            if (isFirstChUpper.test(word)) {
                firstChUpperCaseWords.add(word);
            }
        }

        System.out.println(firstChUpperCaseWords.size());
        for (String firstChUpperCaseWord : firstChUpperCaseWords) {
            System.out.println(firstChUpperCaseWord);
        }
    }
}
