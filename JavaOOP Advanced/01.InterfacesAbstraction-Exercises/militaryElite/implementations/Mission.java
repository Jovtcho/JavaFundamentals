package militaryElite.implementations;

import militaryElite.interfaces.IMission;

public class Mission implements IMission {
    private static final String MISSION_STATUS_FINISHED = "Finished";
    private static final String MISSION_STATUS_IN_PROGRESS = "inProgress";
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {
        if (!MISSION_STATUS_FINISHED.equals(state) && !MISSION_STATUS_IN_PROGRESS.equals(state)) {
            throw new IllegalArgumentException("Invalid state");
        }
        this.state = state;
    }

    public void finishMission() {
        this.setState(MISSION_STATUS_FINISHED);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        //Code Name: <codeName> State: <state>
        return String.format("Code Name: %s State: %s",
                this.getCodeName(), this.getState());
    }
}
