import java.util.*;
import java.util.stream.IntStream;

public class P11GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> players = new LinkedHashMap<>();
        int playersCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < playersCount; i++) {
            String name = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());

            int playerScore = CalculatePlayerScore(name, initialScore);

            players.put(name, playerScore);
        }

        //int maxValue =  Collections.max(players.values());  Last max value
        //String maxKey = Collections.max(players.keySet());  Key corresponding to last max value
        String playerMaxScore = Collections
                .max(players.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
                .getKey(); // First max value

        int maxScore = Collections
                .max(players.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue())
                .getValue(); // Key corresponding to first max value

        System.out.printf("The winner is %s - %d points", playerMaxScore, maxScore);
    }

    public static int CalculatePlayerScore(String name, int initialScore) {
        int score = initialScore;

        for (int j = 0; j < name.length(); j++) {
            int asciiCode = name.charAt(j);

            score = (asciiCode % 2 == 0) ? (score += asciiCode) : (score -= asciiCode);
        }

        return score;
    }
}
