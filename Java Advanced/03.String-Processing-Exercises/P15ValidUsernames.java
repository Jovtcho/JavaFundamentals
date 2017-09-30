import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String regex = "\\b[A-Za-z]\\w{2,24}\\b";
        String inputLine = bf.readLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLine);

        List<String> userNames = new ArrayList<>();

        while (matcher.find()) {
            userNames.add(matcher.group());
        }

        int maxSum = 0;
        String firstUserName = "";
        String secondUserName = "";

        if (userNames.size() == 1) {
            firstUserName = userNames.get(0);
            System.out.println(firstUserName);
            return;
        }

        for (int i = 0; i < userNames.size() - 1; i++) {
            int currentUserNameLen = userNames.get(i).length();
            int nextUserNameLen = userNames.get(i + 1).length();
            int currentSum = currentUserNameLen + nextUserNameLen;

            if (currentSum > maxSum) {
                maxSum = currentSum;
                firstUserName = userNames.get(i);
                secondUserName = userNames.get(i + 1);
            }
        }

        System.out.println(firstUserName);
        System.out.println(secondUserName);
    }
}
