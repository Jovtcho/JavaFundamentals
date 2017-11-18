package militaryElite.implementations;

import militaryElite.interfaces.ISoldier;

public abstract class Soldier implements ISoldier {
    private int id;
    private String firstName;
    private String lastName;

    public Soldier(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id>
        return String.format("Name: %s %s Id: %s",
                this.getFirstName(), this.getLastName(), this.getId());

    }
}
