package p08MilitaryElite.models.implementations;

import p08MilitaryElite.models.Mission;
import p08MilitaryElite.models.interfaces.Commando;

import java.util.*;

public class CommandoImpl extends BaseSpecialisedSoldier implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corpus) {
        super(id, firstName, lastName, salary, corpus);
        this.missions = new ArrayList<>();
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getCorpus() {
        return super.getCorpus();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append("Missions:")
                .append(System.lineSeparator());


        this.missions.stream()
                .filter(m -> m.getState().equals("inProgress"))
                .forEach(m ->
                        sb.append("  ").append(m.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
