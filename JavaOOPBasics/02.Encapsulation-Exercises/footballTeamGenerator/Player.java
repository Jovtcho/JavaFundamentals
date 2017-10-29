package footballTeamGenerator;

public class Player {
    //endurance, sprint, dribble, passing, shooting
    private static final String ENDURANCE_NAME = "Endurance";
    private static final String SPRINT_NAME = "Sprint";
    private static final String DRIBBLE_NAME = "Dribble";
    private static final String PASSING_NAME = "Passing";
    private static final String SHOOTING_NAME = "Shooting";

    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;

    public Player(String name, double endurance, double sprint,
                  double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        isStatValid(endurance, ENDURANCE_NAME);
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        isStatValid(sprint, SPRINT_NAME);
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        isStatValid(dribble, DRIBBLE_NAME);
        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        isStatValid(passing, PASSING_NAME);
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        isStatValid(shooting, SHOOTING_NAME);
        this.shooting = shooting;
    }

    private void isStatValid(double stat, String statName) {
        if (0 > stat || stat > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    public double calculateOverallPlayerSkill() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }
}
