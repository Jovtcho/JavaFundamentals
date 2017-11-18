package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INVALID_COMMAND = "No such command!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Idable> inhabitants = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            Idable inhabitant = getInhabitant(input);

            if (inhabitant != null) {
                inhabitants.add(inhabitant);
            }
        }

        String fakeId = br.readLine();
        List<Idable> detainedInhabitants = new ArrayList<>();
        getDetainedInhabitants(inhabitants, fakeId, detainedInhabitants);

        for (Idable detainedInhabitant : detainedInhabitants) {
            System.out.println(detainedInhabitant.getId());
        }
    }

    private static void getDetainedInhabitants(List<Idable> inhabitants, String fakeId,
                                               List<Idable> detainedInhabitants) {
        for (Idable inhabitant : inhabitants) {
            if (inhabitant.getId().endsWith(fakeId)) {
                detainedInhabitants.add(inhabitant);
            }
        }
    }

    private static Idable getInhabitant(String input) {
        Idable inhabitant = null;
        String[] tokens = input.split("\\s+");
        if (tokens.length == 2) {
            inhabitant = new Robot(tokens[0], tokens[1]);
        } else if (tokens.length == 3) {
            inhabitant = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
        } else {
            System.out.println(INVALID_COMMAND);
        }
        return inhabitant;
    }
}
