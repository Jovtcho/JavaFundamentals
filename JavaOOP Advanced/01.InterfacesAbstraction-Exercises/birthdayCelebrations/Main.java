package birthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INVALID_COMMAND = "No such command!";
    private static final String COMMAND_CITIZEN = "Citizen";
    private static final String COMMAND_ROBOT = "Robot";
    private static final String COMMAND_PET = "Pet";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Idable> inhabitants = new ArrayList<>();
        List<Birthdayable> birthdayables = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            Idable inhabitant = null;
            Birthdayable birthdayable = null;

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case COMMAND_CITIZEN:
                    birthdayable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    break;
                case COMMAND_ROBOT:
                    inhabitant = new Robot(tokens[1], tokens[2]);
                    break;
                case COMMAND_PET:
                    birthdayable = new Pet(tokens[1], tokens[2]);
                    break;
            }

            if (inhabitant != null) {
                inhabitants.add(inhabitant);
            }

            if (birthdayable != null) {
                birthdayables.add(birthdayable);
            }
        }

        String specificYear = br.readLine();
        for (Birthdayable birthdayable : birthdayables) {
            if (birthdayable.getBirthdate().endsWith(specificYear)) {
                System.out.println(birthdayable.getBirthdate());
            }
        }
    }
}
