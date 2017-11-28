package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Importance givenLevel = Importance.valueOf(Importance.class, br.readLine());
        Logger logger = new Logger(givenLevel);

        while (true) {
            String input = br.readLine();
            if ("END".equalsIgnoreCase(input)) {
                break;
            }

            String[] tokens = input.split(":\\s+");
            Importance messageImportance = Importance.valueOf(Importance.class, tokens[0]);
            String description = tokens[1];
            Message message = new Message(messageImportance, description);
            logger.recordMessage(message);
        }

        Iterable<Message> logs = logger.getMessages();
        for (Message log : logs) {
            System.out.println(log);
        }
    }
}
