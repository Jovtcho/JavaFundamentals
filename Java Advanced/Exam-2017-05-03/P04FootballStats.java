import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class P04FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //{team} - {opponent} result {teamGoals}:{opponentGoals}
        Map<String, TreeMap<String, LinkedList<String>>> stats = new HashMap<>();

        while (true) {
            String line = br.readLine();
            if ("Season End".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+result\\s+");
            String[] teams = tokens[0].split("\\s+-\\s+");
            String firstTeam = teams[0].trim();
            String secondTeam = teams[1].trim();
            String resultFirstTeam = tokens[1];
            String resultSecondTeam = new StringBuilder(tokens[1]).reverse().toString();

            stats.putIfAbsent(firstTeam, new TreeMap<>());
            stats.get(firstTeam).putIfAbsent(secondTeam, new LinkedList<>());
            stats.get(firstTeam).get(secondTeam).add(resultFirstTeam);

            stats.putIfAbsent(secondTeam, new TreeMap<>());
            stats.get(secondTeam).putIfAbsent(firstTeam, new LinkedList<>());
            stats.get(secondTeam).get(firstTeam).add(resultSecondTeam);

        }

        String[] searchedTeams = br.readLine().split(",\\s+");

        for (String searchedTeam : searchedTeams) {
            TreeMap<String, LinkedList<String>> teamStats = stats.get(searchedTeam);
            //RealMadrid - Atletico -> 3:0
            for (Map.Entry<String, LinkedList<String>> teamStat : teamStats.entrySet()) {
                LinkedList<String> currentTeamStats = teamStat.getValue();
                for (String currentStat : currentTeamStats) {
                    System.out.printf("%s - %s -> %s%n", searchedTeam, teamStat.getKey(), currentStat);
                }
            }
        }
    }
}
