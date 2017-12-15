package p04_WorkForce.enumerations;

public enum WorkHours {
    StandardEmployeeWorkHours (40),
    PartTimeEmployeeWorkHours (20);

    private int workingHours;

    WorkHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }
}
