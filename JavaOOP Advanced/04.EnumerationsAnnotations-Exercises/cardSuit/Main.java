package cardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deck deck = new Deck();
        Iterable<CardSuit> cardSuits = deck.getDeck();

        if ("Card Suits".equalsIgnoreCase(br.readLine())) {
            System.out.println("Card Suits:");
            for (CardSuit cardSuit : cardSuits) {
                System.out.println(cardSuit.toString());
            }
        }
    }
}
