import java.util.Scanner;
import java.util.regex.Pattern;

public class P09MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\b[A-Z][a-z]{1,} [A-Z][a-z]{1,}\\b";

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            boolean isNameValid = Pattern.matches(regex, input);

            if (isNameValid) {
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
