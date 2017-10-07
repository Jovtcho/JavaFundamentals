import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String regex = "([A-Z](?:[a-zA-Z]+)?)([^a-zA-Z+]*[+]?[0-9]+[()\\/.\\- ]*[0-9]+(?:[()\\/.\\- ]+[0-9]+)*)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, String> phoneBook = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = bf.readLine();

            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            sb.append(line);
        }

        String input = sb.toString();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String name = matcher.group(1);
            String number = matcher.group(2);
            sb.setLength(0);

            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '+') {
                    sb.append(number.charAt(i));
                }

                if (Character.isDigit(number.charAt(i))) {
                    sb.append(number.charAt(i));
                }
            }

            number = sb.toString();
            phoneBook.put(name, number);
        }

        if (phoneBook.isEmpty()){
            System.out.println("<p>No matches!</p>");
            return;
        }

        System.out.print("<ol>");

        for (String name : phoneBook.keySet()) {
            String phoneNumber = phoneBook.get(name);
            System.out.printf("<li><b>%s:</b> %s</li>", name, phoneNumber);
        }

        System.out.print("</ol>");
    }
}
