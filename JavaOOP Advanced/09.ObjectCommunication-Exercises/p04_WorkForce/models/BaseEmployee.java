package p04_WorkForce.models;

public abstract class BaseEmployee implements Employee{
    private String name;
    private int workingHours;

    public BaseEmployee(String name, int workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    @Override
    public int getWorkingHours() {
        return this.workingHours;
    }
}
