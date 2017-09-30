import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String regexKeys = "^(?<startKey>[A-Za-z_]+)\\d.*\\d(?<endKey>[A-Za-z_]+)$";
        Pattern patternKeys = Pattern.compile(regexKeys);

        String keyString = bf.readLine();
        Matcher matcherKeys = patternKeys.matcher(keyString);
        String startKey = "";
        String endKey = "";

        if (matcherKeys.find()) {
            startKey = matcherKeys.group("startKey");
            endKey = matcherKeys.group("endKey");
        } else {
            System.out.println("<p>A key is missing</p>");
            return;
        }

        //startKEY.*?endKEY
        String regexText = startKey + "(?<string>.*?)" + endKey;
        Pattern patternText = Pattern.compile(regexText);
        String textString = bf.readLine();
        Matcher matcherText = patternText.matcher(textString);

        List<Double> nums = new ArrayList<>();

        while (matcherText.find()) {
            String str = matcherText.group("string");
            try {
                double num = Double.parseDouble(str);
                nums.add(num);

            } catch (NumberFormatException e) {
                continue;
            }
        }

        double sum = nums.stream().mapToDouble(Double::doubleValue).sum();

        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
            return;
        }


        if (sum % 1 == 0) {
            System.out.printf("<p>The total value is: <em>%d</em></p>", (int) sum);
        } else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
        }
    }
}
