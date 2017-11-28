package cardRank;

public enum  CardRanks {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;


    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", super.ordinal(), super.name());
    }
}
