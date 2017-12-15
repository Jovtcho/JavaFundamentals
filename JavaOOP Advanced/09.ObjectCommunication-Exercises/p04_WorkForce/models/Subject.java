package p04_WorkForce.models;

import java.util.List;

public interface Subject {
    List<Job> getJobs();

    void registerJob(Job job);

    void unregisterJob(Job job);

    void notifyObserver(Job job);
}
