package footballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private double rating;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
        this.rating = 0.0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getRating() {
        this.rating = calculateTeamRating();
        return this.rating;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isPlayerInTeam = this.players.stream().anyMatch(player -> player.getName().equals(playerName));
        if (!isPlayerInTeam) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        this.players.removeIf(player -> player.getName().equals(playerName));
    }

    private double calculateTeamRating() {
        if (this.players.isEmpty()) {
            return 0.0;
        }
        return players.stream().mapToDouble(Player::calculateOverallPlayerSkill).average().getAsDouble();
    }
}
