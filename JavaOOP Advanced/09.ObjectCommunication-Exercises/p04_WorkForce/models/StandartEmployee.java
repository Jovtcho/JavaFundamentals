package p04_WorkForce.models;

import p04_WorkForce.enumerations.WorkHours;

public class StandartEmployee extends BaseEmployee {
    public StandartEmployee(String name) {
        super(name, WorkHours.StandardEmployeeWorkHours.getWorkingHours());
    }
}
