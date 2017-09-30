import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[\\w-]{3,16}$";
        Pattern pattern = Pattern.compile(regex);
        String line = scanner.nextLine();

        List<String> usernames = new ArrayList<>();

        while (true) {
            if ("END".equals(line)) {
                break;
            }

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                usernames.add("valid");
            } else {
                usernames.add("invalid");
            }

            line = scanner.nextLine();
        }

        if (!usernames.contains("valid")) {
            return;
        } else {
            for (String username : usernames) {
                System.out.println(username);
            }
        }
    }
}
