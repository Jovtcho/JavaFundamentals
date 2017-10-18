import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedList<String>> playersOpponents = new LinkedHashMap<>();
        Map<String, Long> playersPoints = new LinkedHashMap<>();

        while (true) {
            String line = br.readLine();
            if ("osu!".equalsIgnoreCase(line)) {
                break;
            }

            //2000 Ivan<->Pesho 10000
            String[] tokens = line.split("<->");

            String[] tokensPlayer1 = tokens[0].split("\\s+");
            long player1Score = Long.valueOf(tokensPlayer1[0]);
            String player1Name = tokensPlayer1[1];
            String[] tokensPlayer2 = tokens[1].split("\\s+");
            String player2Name = tokensPlayer2[0];
            long player2Score = Long.valueOf(tokensPlayer2[1]);

            if (player1Name.equalsIgnoreCase(player2Name)) {
                continue;
            }

            long player1Points = player1Score - player2Score;
            long player2Points = player2Score - player1Score;

            //*   Rafis <-> -19307994
            StringBuilder sb = new StringBuilder();
            sb.append("*   ").append(player2Name).append(" <-> ").append(player1Points);
            playersOpponents.putIfAbsent(player1Name, new LinkedList<>());
            LinkedList opponents1 = playersOpponents.get(player1Name);
            opponents1.add(sb.toString());
            playersOpponents.put(player1Name, opponents1);

            playersPoints.putIfAbsent(player1Name, 0L);
            long player1TotalPoints = playersPoints.get(player1Name) + player1Points;
            playersPoints.put(player1Name, player1TotalPoints);

            sb.setLength(0);
            sb.append("*   ").append(player1Name).append(" <-> ").append(player2Points);
            playersOpponents.putIfAbsent(player2Name, new LinkedList<>());
            LinkedList opponents2 = playersOpponents.get(player2Name);
            opponents2.add(sb.toString());
            playersOpponents.putIfAbsent(player2Name, opponents2);

            playersPoints.putIfAbsent(player2Name, 0L);
            long player2TotalPoints = playersPoints.get(player2Name) + player2Points;
            playersPoints.put(player2Name, player2TotalPoints);

        }

        LinkedHashMap<String, Long> sortedPlayersByPoints = playersPoints.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue
                        , (e1, e2) -> e1, LinkedHashMap::new));

        for (String player : sortedPlayersByPoints.keySet()) {
            long playerPoints = sortedPlayersByPoints.get(player);
            System.out.printf("%s - (%d)%n", player, playerPoints);

            LinkedList<String> playerOpponents = playersOpponents.get(player);
            for (String playerOpponent : playerOpponents) {
                System.out.println(playerOpponent);
            }
        }
    }
}
