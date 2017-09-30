import java.util.Scanner;
import java.util.regex.Pattern;

public class P10MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^\\+359([ |-])2\\1\\d{3}\\1\\d{4}$";

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            boolean isNumberValid = Pattern.matches(regex, input);

            if (isNumberValid) {
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
