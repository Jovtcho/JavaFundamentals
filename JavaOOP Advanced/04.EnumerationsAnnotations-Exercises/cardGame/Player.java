package cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getHighestCard() {
        this.cards.sort(new CardComparator());
        return this.cards.get(this.cards.size() - 1);
    }
}
