package deckOfCards;

public class Card {
    private CardRanks cardRanks;
    private CardSuit cardSuit;


    public Card(CardRanks cardRanks, CardSuit cardSuit) {
        this.cardRanks = cardRanks;
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.cardRanks.name(), this.cardSuit.name());
    }
}
