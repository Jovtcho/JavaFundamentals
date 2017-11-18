package p08MilitaryElite.models.interfaces;

import p08MilitaryElite.models.Repair;

import java.util.List;
import java.util.Map;

public interface Engineer {
    void addRepair(Repair repair);
    List<Repair> getRepairs();
}
