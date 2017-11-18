package p08MilitaryElite.models.interfaces;

import p08MilitaryElite.models.Mission;

import java.util.List;

public interface Commando extends SpecialisedSoldier {
    void addMission(Mission mission);
    List<Mission> getMissions();
}
