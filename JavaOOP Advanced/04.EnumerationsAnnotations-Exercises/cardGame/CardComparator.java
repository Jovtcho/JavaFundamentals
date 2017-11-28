package cardGame;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    public CardComparator() {
    }

    @Override
    public final int compare(Card firstCard, Card secondCard) {
        return firstCard.compareTo(secondCard);
    }
}
