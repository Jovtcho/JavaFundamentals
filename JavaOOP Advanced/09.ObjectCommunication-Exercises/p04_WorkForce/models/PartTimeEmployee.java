package p04_WorkForce.models;

import p04_WorkForce.enumerations.WorkHours;

public class PartTimeEmployee extends BaseEmployee {
    public PartTimeEmployee(String name) {
        super(name, WorkHours.PartTimeEmployeeWorkHours.getWorkingHours());
    }
}
