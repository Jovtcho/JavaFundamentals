package p08MilitaryElite.models.implementations;

import p08MilitaryElite.models.interfaces.SpecialisedSoldier;

public abstract class BaseSpecialisedSoldier extends PrivateImpl implements SpecialisedSoldier {
    private String corpus;

    protected BaseSpecialisedSoldier(int id, String firstName, String lastName, double salary, String corpus) {
        super(id, firstName, lastName, salary);
        this.corpus = corpus;
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
        return this.corpus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Corps: %s", this.getCorpus()))
                .append(System.lineSeparator());

        return sb.toString();
    }
}
