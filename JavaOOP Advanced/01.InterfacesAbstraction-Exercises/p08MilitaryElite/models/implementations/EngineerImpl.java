package p08MilitaryElite.models.implementations;

import p08MilitaryElite.models.Repair;
import p08MilitaryElite.models.interfaces.Engineer;

import java.util.*;

public class EngineerImpl extends BaseSpecialisedSoldier implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corpus) {
        super(id, firstName, lastName, salary, corpus);
        this.repairs = new ArrayList<>();
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
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append("Repairs:")
                .append(System.lineSeparator());

        this.repairs.forEach(r -> sb.append("  ").append(r.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
