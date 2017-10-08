import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P12ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(bf.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> filteredGuests = new ArrayList<>();

        while (true) {
            String line = bf.readLine();
            if ("print".equalsIgnoreCase(line)) {
                break;
            }

            String[] commands = line.split(";");
            String command = commands[0];
            String filterType = commands[1];
            String filterParam = commands[2];
            Predicate<String> tester = createTester(filterType, filterParam);

            if ("add filter".equalsIgnoreCase(command)) {
                for (String guest : guests) {
                    if (tester.test(guest)) {
                        filteredGuests.add(guest);
                    }
                }
            } else if ("remove filter".equalsIgnoreCase(command)) {
                //filtered.removeIf(tester);  sashoto e kato dolnia kod
                for (int i = 0; i < filteredGuests.size(); i++) {
                    if (tester.test(filteredGuests.get(i))) {
                        filteredGuests.remove(filteredGuests.get(i));
                        i--;
                    }
                }
            } else {
                System.out.println("No such command!");
            }
        }

        guests.removeAll(filteredGuests);
        System.out.println(Arrays.toString(guests.toArray()).replaceAll("[\\[\\],]", ""));
    }

    private static Predicate<String> createTester(String filterType, String filterParam) {
        if ("starts with".equalsIgnoreCase(filterType)) {
            return str -> str.startsWith(filterParam);
        } else if ("ends with".equalsIgnoreCase(filterType)) {
            return str -> str.endsWith(filterParam);
        } else if ("length".equalsIgnoreCase(filterType)) {
            return str -> str.length() == Integer.valueOf(filterParam);
        } else if ("contains".equalsIgnoreCase(filterType)) {
            return str -> str.contains(filterParam);
        } else {
            return null;
        }
    }
}
