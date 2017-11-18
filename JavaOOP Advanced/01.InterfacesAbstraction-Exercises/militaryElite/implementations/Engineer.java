package militaryElite.implementations;

import militaryElite.interfaces.IEngineer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.setRepairs();
    }

    private void setRepairs() {
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        // Name: <firstName> <lastName> Id: <id> Salary: <salary>
        //         Corps: <corps>
        //         Repairs:
        //         <repair1 ToString()>
        //         <repair2 ToString()>
        //         …
        //         <repairN ToString()>

        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        if (!this.getRepairs().isEmpty()) {
            for (Repair repair : repairs) {
                sb.append("  ").append(repair.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }


}
