import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(bf.readLine().split("\\s+")).collect(Collectors.toList());

        while (true) {
            String line = bf.readLine();

            if ("Party!".equalsIgnoreCase(line)) {
                break;
            }
            String[] commands = line.split("\\s+");
            String action = commands[0];
            String command = commands[1];
            String commandParam = commands[2];
            Predicate<String> tester = createTester(command, commandParam);

            if ("remove".equalsIgnoreCase(action)) {
                for (int index = 0; index < guests.size(); index++) {
                    if (tester.test(guests.get(index))) {
                        guests.remove(index);
                        index--;
                    }
                }
            } else if ("double".equalsIgnoreCase(action)) {
                for (int index = 0; index < guests.size(); index++) {
                    if (tester.test(guests.get(index))) {
                        guests.add(index, guests.get(index));
                        index++;
                    }
                }
            } else {
                System.out.println("No such command!");
            }
        }

        System.out.println(guests.size() == 0
                ? "Nobody is going to the party!"
                : Arrays.toString(guests.toArray())
                .replaceAll("[\\[\\],]", "").replace(" ", ", ")
                + " are going to the party!");
    }

    private static Predicate<String> createTester(String command, String commandParam) {
        if ("startswith".equalsIgnoreCase(command)) {
            return str -> str.startsWith(commandParam);
        } else if ("endswith".equalsIgnoreCase(command)) {
            return str -> str.endsWith(commandParam);
        } else if ("length".equalsIgnoreCase(command)) {
            return str -> str.length() == Integer.valueOf(commandParam);
        } else {
            return null;
        }
    }
}