package cardSuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<CardSuit> cardSuits;

    public Deck() {
        this.setCardSuits();
    }

    private void setCardSuits() {
        this.cardSuits = new ArrayList<>();
        Collections.addAll(this.cardSuits, CardSuit.values());
    }

    public Iterable<CardSuit> getDeck() {
        return this.cardSuits;
    }
}
