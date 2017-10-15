import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<large>>{3}-{5}>{2})|(?<medium>>{2}-{5}>)|(?<small>>-{5}>)";
        Pattern pattern = Pattern.compile(regex);

        int largeCount = 0;
        int mediumCount = 0;
        int smallCount = 0;

        for (int index = 0; index < 4; index++) {
            String line = bf.readLine();
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group("large") != null) {
                    largeCount++;
                } else if (matcher.group("medium") != null) {
                    mediumCount++;
                } else {
                    smallCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(smallCount).append(mediumCount).append(largeCount);
        String arrowsToBinary = Integer.toBinaryString(Integer.valueOf(sb.toString()));
        sb.setLength(0);
        sb.append(arrowsToBinary);
        String reversedArrowsToBinary = sb.reverse().toString();
        sb.setLength(0);
        sb.append(arrowsToBinary).append(reversedArrowsToBinary);

        long encryptedMessage = Integer.parseInt(sb.toString(), 2);
        System.out.println(encryptedMessage);
    }
}
