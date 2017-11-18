package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final String INVALID_COMMAND = "No such command!";
    private static final String COMMAND_CITIZEN = "Citizen";
    private static final String COMMAND_ROBOT = "Robot";
    private static final String COMMAND_PET = "Pet";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Buyer> buyers = new ArrayList<>();
        int peopleCount = Integer.parseInt(br.readLine());
        List<String> foodBuyers = new ArrayList<>();

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = br.readLine().split("\\s+");

            Buyer buyer = null;
            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            } else if (tokens.length == 3) {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                System.out.println(INVALID_COMMAND);
            }

            if (buyer != null) {
                buyers.add(buyer);
            }
        }

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            foodBuyers.add(input);
        }

        for (String foodBuyer : foodBuyers) {
            boolean isFoodBuyerExist = buyers.
                    stream().
                    anyMatch(buyer -> buyer.getName().equals(foodBuyer));
            if (isFoodBuyerExist) {
                Buyer currentBuyer = buyers
                        .stream()
                        .filter(buyer -> buyer.getName().equals(foodBuyer))
                        .collect(Collectors.toList())
                        .get(0);
                currentBuyer.buyFood();
            }
        }

        int totalBoughtFood = 0;
        for (Buyer buyer : buyers) {
            totalBoughtFood += buyer.getFood();
        }
        System.out.println(totalBoughtFood);
    }
}
