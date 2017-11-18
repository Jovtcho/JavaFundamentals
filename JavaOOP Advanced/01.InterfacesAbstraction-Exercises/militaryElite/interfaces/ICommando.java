package militaryElite.interfaces;

import militaryElite.implementations.Mission;

import java.util.List;

public interface ICommando extends ISpecialisedSoldier{
    List<Mission> getMissions();

    void addMission(Mission mission);

    void completeMission(Mission mission);
}
