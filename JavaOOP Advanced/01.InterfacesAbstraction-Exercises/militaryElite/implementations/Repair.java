package militaryElite.implementations;

import militaryElite.interfaces.IRepair;

public class Repair implements IRepair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        //Part Name: <partName> Hours Worked: <hoursWorked>
        return String.format("Part Name: %s Hours Worked: %s",
                this.getPartName(), this.getHoursWorked());
    }
}


