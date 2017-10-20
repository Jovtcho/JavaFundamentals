import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P01HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //2C 2H 2D AS 10H 10C 2S KD
        String[] cards = br.readLine().split("\\s+");
        int[] cardsValue = new int[cards.length];
        char[] cardsSuit = new char[cards.length];

        for (int index = 0; index < cards.length; index++) {
            String currentCard = cards[index];
            int value;
            char suit;

            if (currentCard.length() == 2) {
                char ch = currentCard.charAt(0);
                switch (ch) {
                    case 'J':
                        value = 12;
                        break;
                    case 'Q':
                        value = 13;
                        break;
                    case 'K':
                        value = 14;
                        break;
                    case 'A':
                        value = 15;
                        break;
                    default:
                        value = Integer.parseInt(currentCard.substring(0, 1));
                        break;
                }

                suit = currentCard.charAt(1);
            } else {
                char ch = currentCard.charAt(0);
                switch (ch) {
                    case 'J':
                        value = 12;
                        break;
                    case 'Q':
                        value = 13;
                        break;
                    case 'K':
                        value = 14;
                        break;
                    case 'A':
                        value = 15;
                        break;
                    default:
                        value = Integer.parseInt(currentCard.substring(0, 2));
                        break;
                }

                suit = currentCard.charAt(2);
            }

            cardsValue[index] = value;
            cardsSuit[index] = suit;
        }

        int sum = 0;
        int tempSum = 0;
        int counter = 1;
        for (int index = 1; index < cardsSuit.length; index++) {
            char previousCh = cardsSuit[index - 1];
            char currentCh = cardsSuit[index];

            if (previousCh != currentCh) {
                if (counter > 1) {
                    tempSum += cardsValue[index - 1];
                    sum += tempSum * counter;
                    tempSum = 0;
                    counter = 1;
                    continue;
                }

                sum += cardsValue[index - 1];
            } else {
                tempSum += cardsValue[index - 1];
                counter++;
            }
        }

        if (counter > 1) {
            tempSum += cardsValue[cardsValue.length - 1];
            sum += tempSum * counter;
        } else {
            sum += cardsValue[cardsValue.length - 1];
        }

        System.out.println(sum);
    }
}
