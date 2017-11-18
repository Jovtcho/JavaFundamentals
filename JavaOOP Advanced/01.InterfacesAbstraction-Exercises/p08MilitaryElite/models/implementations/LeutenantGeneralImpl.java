package p08MilitaryElite.models.implementations;

import p08MilitaryElite.models.interfaces.LeutenantGeneral;
import p08MilitaryElite.models.interfaces.Private;

import java.util.*;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private List<Private> privatesUnderCommand;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privatesUnderCommand = new ArrayList<>();
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
    public void addPrivate(Private _private) {
        this.privatesUnderCommand.add(_private);
    }

    @Override
    public Collection<Private> getPrivatesUnderCommand() {
        return Collections.unmodifiableCollection(this.privatesUnderCommand);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());

        this.getPrivatesUnderCommand().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getId(), p1.getId()))
                .forEach(p ->
                        sb.append("  ").append(p.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
