package militaryElite.interfaces;

import militaryElite.implementations.Repair;

import java.util.List;

public interface IEngineer extends ISpecialisedSoldier{
    List<Repair> getRepairs();

    void addRepair(Repair repair);
}
