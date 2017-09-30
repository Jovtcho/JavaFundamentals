import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String word = bf.readLine();
        String wordRegex = "\\b" + word + "\\b";

        String inputText = bf.readLine();
        String sentenceRegex = "(\\S.+?[.!?])(?=\\s+|$)";

        Pattern patternSentence = Pattern.compile(sentenceRegex);
        Matcher matcherSentence = patternSentence.matcher(inputText);

        Pattern patternWord = Pattern.compile(wordRegex);

        while (matcherSentence.find()) {
            String currentSentence = matcherSentence.group();

            Matcher matcherWord = patternWord.matcher(currentSentence);

            if (matcherWord.find()) {
                System.out.println(currentSentence.trim());
            }
        }
    }
}
