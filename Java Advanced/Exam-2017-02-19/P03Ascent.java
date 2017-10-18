import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(?<add>,[A-Za-z]+\\d)|(?<subtract>_[A-Za-z]+\\d)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, String> memorized = new LinkedHashMap<>();
        List<String> decryptedLines = new LinkedList<>();

        while (true) {
            String line = bf.readLine();
            if ("Ascend".equalsIgnoreCase(line)) {
                break;
            }

            for (Map.Entry<String, String> memorize : memorized.entrySet()) {
                String crypted = memorize.getKey();
                String decrypted = memorize.getValue();

                if (line.contains(crypted)) {
                    line = line.replaceAll(crypted, decrypted);
                }
            }

            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String match = matcher.group();
                int num = match.charAt(match.length() - 1) - 48;
                StringBuilder sb = new StringBuilder();

                if (match.charAt(0) == ',') {
                    for (int index = 1; index < match.length() - 1; index++) {
                        sb.append((char) (match.charAt(index) + num));
                    }

                    //line = line.replaceAll(match, sb.toString());
                } else if (match.charAt(0) == '_') {
                    for (int index = 1; index < match.length() - 1; index++) {
                        sb.append((char) (match.charAt(index) - num));
                    }

                    //line = line.replaceAll(match, sb.toString());
                } else {
                    System.out.println("Problem!");
                }

                line = line.replaceAll(match, sb.toString());
                memorized.putIfAbsent(match, sb.toString());
            }

            decryptedLines.add(line);
        }

        for (String decryptedLine : decryptedLines) {
            System.out.println(decryptedLine);
        }
    }
}
