package cardGame;

public class Card implements Comparable<Card> {
    private CardRanks cardRanks;
    private CardSuit cardSuit;
    private String cardName;

    public Card(CardRanks cardRanks, CardSuit cardSuit) {
        this.cardRanks = cardRanks;
        this.cardSuit = cardSuit;
        this.cardName = this.cardRanks.name() + this.cardSuit.name();
    }

    public String getCardName() {
        return this.cardName;
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
        return String.format("%s of %s", this.cardRanks.name(), this.cardSuit.name());
    }
}
