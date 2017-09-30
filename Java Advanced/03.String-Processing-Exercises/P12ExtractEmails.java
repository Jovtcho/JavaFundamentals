import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class P12ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //String regex = "((?<=\\s)[a-zA-Z0-9]+([-.]\\w*)*@[a-zA-Z]+?([.-][a-zA-Z]*)*(\\.[a-z]{2,}))";
        String regex = "(^|\\s+)[a-zA-Z0-9]+([-.]\\w*)*@[a-zA-Z]+?([.-][a-zA-Z]*)*(\\.[a-z]{2,})";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String inputLine = bf.readLine();

            if ("end".equalsIgnoreCase(inputLine)) {
                break;
            }

            Matcher matcher = pattern.matcher(inputLine);

            while (matcher.find()){
                System.out.println(matcher.group().trim());
            }
        }
    }
}
