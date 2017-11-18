package militaryElite.implementations;

import militaryElite.interfaces.ISpecialisedSoldier;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private static final String AIRFORCE_CORPS = "Airforces";
    private static final String MARINE_CORPS = "Marines";
    private String corps;

    protected SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (!AIRFORCE_CORPS.equals(corps) && !MARINE_CORPS.equals(corps)) {
            throw new IllegalArgumentException("Invalid corps");
        }
        this.corps = corps;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id> Salary: <salary>
        //Corps: <corps>
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps());
        return sb.toString();
    }
}
