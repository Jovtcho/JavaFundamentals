package firstReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private static final int AGE_TEAM_LIMIT = 40;

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

 //  public List<Person> getFirstTeam() {
 //      return Collections.unmodifiableList(this.firstTeam);
 //  }

 //  public List<Person> getReserveTeam() {
 //      return Collections.unmodifiableList(this.reserveTeam);
 //  }

    public int getTeamCount(String team) {
        if ("first".equalsIgnoreCase(team)) {
            return this.firstTeam.size();
        } else if ("reserve".equalsIgnoreCase(team)) {
            return this.reserveTeam.size();
        } else {
            return -1;
        }
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeam.add(player);
        } else {
            this.reserveTeam.add(player);
        }
    }
}
