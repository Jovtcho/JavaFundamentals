package deckOfCards;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private List<Card> cards;

    public DeckOfCards() {
        this.setCardSuits();
    }

    private void setCardSuits() {
        this.cards = new ArrayList<>();
        CardRanks[] cardRanks = CardRanks.values();
        CardSuit[] cardSuits = CardSuit.values();
        for (CardSuit cardSuit : cardSuits) {
            for (CardRanks cardRank : cardRanks) {
                Card card = new Card(cardRank, cardSuit);
                this.cards.add(card);
            }
        }
    }

    public Iterable<Card> getDeckOfCards() {
        return this.cards;
    }
}
