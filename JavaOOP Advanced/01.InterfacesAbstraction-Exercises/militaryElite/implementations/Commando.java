package militaryElite.implementations;

import militaryElite.interfaces.ICommando;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps
    ) {
        super(id, firstName, lastName, salary, corps);
        this.setMissions();
    }

    private void setMissions() {
        this.missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public void completeMission(Mission mission) {
        String codeName = mission.getCodeName();
        Mission currentMission = this.getMissions()
                .stream()
                .filter(m -> m.getCodeName().equals(codeName))
                .collect(Collectors.toList())
                .get(0);

        if (currentMission != null) {
            currentMission.finishMission();
        }
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id> Salary: <salary>
        //        Corps: <corps>
        //        Missions:
        //        <mission1 ToString()>
        //        <mission2 ToString()>
        //         …
        //         <missionN ToString()>

        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        if (!this.getMissions().isEmpty()) {
            for (Mission mission : missions) {
                sb.append("  ").append(mission.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
