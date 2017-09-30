import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ExtractTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "<.*?>";
        Pattern pattern = Pattern.compile(regex);

        List<String> inputLines = new ArrayList<>();
        readInput(scanner, inputLines);

        List<String> tags = new ArrayList<>();
        findTags(pattern, inputLines, tags);

        printTags(tags);
    }

    private static void printTags(List<String> tags) {
        for (String tag : tags) {
            System.out.println(tag);
        }
    }

    private static void findTags(Pattern pattern, List<String> inputLines, List<String> tags) {
        for (String inputLine : inputLines) {
            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()) {
                tags.add(matcher.group());
            }
        }
    }

    private static void readInput(Scanner scanner, List<String> inputLines) {
        String line = scanner.nextLine();

        while (true) {
            if ("END".equals(line)) {
                break;
            }

            inputLines.add(line);
            line = scanner.nextLine();
        }
    }
}
