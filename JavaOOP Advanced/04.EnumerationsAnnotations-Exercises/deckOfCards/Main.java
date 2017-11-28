package deckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DeckOfCards deck = new DeckOfCards();
        Iterable<Card> cards = deck.getDeckOfCards();

        if ("Card Deck".equalsIgnoreCase(br.readLine())) {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
}
