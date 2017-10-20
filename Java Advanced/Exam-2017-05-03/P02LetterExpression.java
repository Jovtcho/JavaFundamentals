import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("#.#######");
        String input = br.readLine();
        Deque<Double> nums = new ArrayDeque<>();
        Deque<String> signs = new ArrayDeque<>();

        //String regexNums = "\\d+\\.*\\d*";
        String regexNums = "\\d+";
        String regexSymbols = "[^\\d]+";

        Pattern patternNum = Pattern.compile(regexNums);
        Pattern patternSymbol = Pattern.compile(regexSymbols);

        Matcher matcherNums = patternNum.matcher(input);
        Matcher matcherSymbols = patternSymbol.matcher(input);

        while (matcherNums.find()) {
            nums.addLast(Double.valueOf(matcherNums.group()));
        }

        if (nums.size() == 0) {
            return;
        }

        if (nums.size() == 1) {
            System.out.println(df.format(nums.pollFirst()));
            return;
        }

        while (matcherSymbols.find()) {
            if (matcherSymbols.group().length() % 2 == 0) {
                signs.addLast("+");
            } else {
                signs.addLast("-");
            }
        }

        if (signs.size() == nums.size()) {
            signs.pollLast();
        }

        double sum = nums.pollFirst();
        while (!signs.isEmpty()) {
            double num = nums.pollFirst();
            String sign = signs.pollFirst();

            if ("+".equals(sign)) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        System.out.println(df.format(sum));
    }
}
