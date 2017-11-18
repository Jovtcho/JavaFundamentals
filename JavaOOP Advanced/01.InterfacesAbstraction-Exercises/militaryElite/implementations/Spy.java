package militaryElite.implementations;

import militaryElite.interfaces.ISpy;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        //Name: <firstName> <lastName> Id: <id>
        //Code Number: <codeNumber>

        return String.format("%s%nCode Number: %s", super.toString(), this.getCodeNumber());
    }
}
