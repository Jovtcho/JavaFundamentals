package cardsPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstCardRank = br.readLine();
        String firstCardSuit = br.readLine();
        Card firstCard = new Card
                (Enum.valueOf(CardRanks.class, firstCardRank), Enum.valueOf(CardSuit.class, firstCardSuit));
        String secondCardRank = br.readLine();
        String secondcardSuit = br.readLine();
        Card secondCard = new Card
                (Enum.valueOf(CardRanks.class, secondCardRank), Enum.valueOf(CardSuit.class, secondcardSuit));

        System.out.println(
                firstCard.compareTo(secondCard) >= 0
                        ? firstCard.toString()
                        : secondCard.toString());
    }
}
