package p04_WorkForce.models;

public interface Job {
    String getName();

    int getWorkRequiredHours();

    boolean isFinished();

    void update();
}
