package p04_WorkForce.models;

public class JobImpl implements Job {
    private static final String JOB_IS_DONE = "Job %s done!";

    private String name;
    private int workRequiredHours;
    private Employee employee;
    private boolean isFinished;

    public JobImpl(String name, int workRequiredHours, Employee employee) {
        this.name = name;
        this.workRequiredHours = workRequiredHours;
        this.employee = employee;
        isFinished = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWorkRequiredHours() {
        return this.workRequiredHours;
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }

    @Override
    public void update() {
        this.workRequiredHours -= this.employee.getWorkingHours();

        if (this.workRequiredHours <= 0) {
            isFinished = true;
        }
    }

    @Override
    public String toString() {
        return String.format(JOB_IS_DONE, this.name);
    }
}
