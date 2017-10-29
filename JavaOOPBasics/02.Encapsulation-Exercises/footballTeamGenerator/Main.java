package footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new HashMap<>();

        while (true) {
            String line = br.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            String playerName = "";

            Team team = null;
            switch (command.toLowerCase()) {
                case "team":
                    try {
                        team = new Team(teamName);
                        teams.putIfAbsent(teamName, team);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "add":
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        continue;
                    }

                    playerName = tokens[2];
                    double endurance = Double.parseDouble(tokens[3]);
                    double sprint = Double.parseDouble(tokens[4]);
                    double dribble = Double.parseDouble(tokens[5]);
                    double passing = Double.parseDouble(tokens[6]);
                    double shooting = Double.parseDouble(tokens[7]);

                    try {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "remove":
                    playerName = tokens[2];
                    try {
                        teams.get(teamName).removePlayer(playerName);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "rating":
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        continue;
                    }

                    System.out.println(String.format("%s - %.0f", teamName, teams.get(teamName).getRating()));
                    break;
                default:
                    System.out.println("No such command.");
            }
        }
    }
}
