package cardsPower;

import java.util.Comparator;

public class Card implements Comparable<Card> {
    private CardRanks cardRanks;
    private CardSuit cardSuit;
    //private int cardPower;

    public Card(CardRanks cardRanks, CardSuit cardSuit) {
        this.cardRanks = cardRanks;
        this.cardSuit = cardSuit;
        //this.cardPower = 0;
    }

    private int getCardPower() {
        return this.cardRanks.getPower() + this.cardSuit.getPower();
    }

    @Override
    public int compareTo(Card other) {
        return this.getCardPower() - other.getCardPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.cardRanks.name(), this.cardSuit.name(), this.getCardPower());
    }
}
