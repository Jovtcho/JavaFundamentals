package cardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CardRanks[] deck = CardRanks.values();
        if ("Card Ranks".equalsIgnoreCase(br.readLine())) {
            System.out.println("Card Ranks:");
            for (CardRanks cardRank : deck) {
                System.out.println(cardRank.toString());
            }
        }

    }
}
