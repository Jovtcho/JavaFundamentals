package cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DeckOfCards deckOfCards = new DeckOfCards();
        String playerName;

        playerName = br.readLine();
        Player firstPlayer = new Player(playerName);

        playerName = br.readLine();
        Player secondPlayer = new Player(playerName);

        getPlayersCard(br, deckOfCards, firstPlayer);
        getPlayersCard(br, deckOfCards, secondPlayer);

        System.out.println(getWinner(firstPlayer, secondPlayer));
    }

    private static String getWinner(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer.getHighestCard().compareTo(secondPlayer.getHighestCard()) > 0) {
            return String.format("%s wins with %s.",
                    firstPlayer.getName(), firstPlayer.getHighestCard().toString());
        }
        return String.format("%s wins with %s.",
                secondPlayer.getName(), secondPlayer.getHighestCard().toString());

    }

    private static void getPlayersCard(BufferedReader br,
                                       DeckOfCards deckOfCards, Player player) throws IOException {
        while (player.getCards().size() < 5) {
            String[] tokens = br.readLine().split("\\s+");
            String cardRank = tokens[0];
            String cardSuit = tokens[2];
            boolean isValidCard = checkIsCardValid(tokens);

            if (isValidCard) {
                Card card = new Card(CardRanks.valueOf(cardRank), CardSuit.valueOf(cardSuit));
                try {
                    deckOfCards.drawCard(card);
                    player.addCard(card);
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
            } else {
                System.out.println("No such card exists.");
            }
        }
    }

    private static boolean checkIsCardValid(String[] tokens) {
        boolean isValidRank = Arrays.stream(CardRanks.values())
                .map(CardRanks::name)
                .collect(Collectors.toList())
                .contains(tokens[0]);
        boolean isValidSuit = Arrays.stream(CardSuit.values())
                .map(CardSuit::name)
                .collect(Collectors.toList())
                .contains(tokens[2]);
        return isValidRank && isValidSuit;
    }
}
