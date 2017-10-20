import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P03NaturalMessagingService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> message = new LinkedList<>();
        List<Character> copyOfMessage = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if ("---NMS SEND---".equalsIgnoreCase(line)) {
                break;
            }

            sb.append(line);
        }

        String delimiter = br.readLine();

        for (char ch : sb.toString().toCharArray()) {
            message.add(ch);
            copyOfMessage.add(Character.toUpperCase(ch));
        }

        int offset = 1;
        for (int index = 0; index < copyOfMessage.size() - 1; index++) {
            char currentCh = copyOfMessage.get(index);
            char nextCh = copyOfMessage.get(index + 1);
            if (currentCh > nextCh) {
                message.add(index + offset, '*');
                offset++;
            }
        }

        sb.setLength(0);
        for (Character ch : message) {
            if (ch != '*') {
                sb.append(ch);
            } else {
                sb.append(delimiter);
            }
        }

        System.out.println(sb.toString());
    }
}
