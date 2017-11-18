package militaryElite.implementations;

import militaryElite.interfaces.ILeutenantGeneral;

import java.util.*;

public class LeutenantGeneral extends Private implements ILeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.setPrivates();
    }

    private void setPrivates() {
        this.privates = new ArrayList<>();
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public void addPrivate(Private privateSoldier) {
        this.privates.add(privateSoldier);
    }

    @Override
    // Name: <firstName> <lastName> Id: <id> Salary: <salary>
    // Privates:
    // <private1 ToString()>
    // <private2 ToString()>
    //         …
    // <privateN ToString()>
    // Note: privates must be sorted by id in descending order.

    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        this.privates.
                stream()
                .sorted((p1, p2) -> Integer.compare(p2.getId(), p1.getId()))
                .forEach(p -> sb.append("  ").append(p.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
