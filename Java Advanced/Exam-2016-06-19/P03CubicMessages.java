import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03CubicMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^(?<indexBefore>\\d+)(?<message>[A-Za-z]+)(?<indexAfter>[^A-Za-z]*)$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String line = br.readLine();
            if ("Over!".equalsIgnoreCase(line)) {
                break;
            }

            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()) {
                continue;
            }

            int messageLength = Integer.valueOf(br.readLine());
            String message = matcher.group("message");

            if (message.length() != messageLength) {
                continue;
            }

            String indexBeforeStr = matcher.group("indexBefore");
            String indexAfterStr = matcher.group("indexAfter");
            List<Integer> indexBefore = new LinkedList<>();
            List<Integer> indexAfter = new LinkedList<>();

            for (int i = 0; i < indexBeforeStr.length(); i++) {
                int index = Integer.parseInt(String.valueOf(indexBeforeStr.charAt(i)));
                indexBefore.add(index);
            }

            for (int i = 0; i < indexAfterStr.length(); i++) {
                if (Character.isDigit(indexAfterStr.charAt(i))) {
                    int index = Integer.parseInt(String.valueOf(indexAfterStr.charAt(i)));
                    indexAfter.add(index);
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < indexBefore.size(); i++) {
                if (indexBefore.get(i) < message.length()) {
                    sb.append(message.charAt(indexBefore.get(i)));
                } else {
                    sb.append(" ");
                }
            }

            for (int i = 0; i < indexAfter.size(); i++) {
                if (indexAfter.get(i) < message.length()) {
                    sb.append(message.charAt(indexAfter.get(i)));
                } else {
                    sb.append(" ");
                }
            }

            System.out.printf("%s == %s%n", message, sb.toString());
        }
    }
}
