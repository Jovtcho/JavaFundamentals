package p04_WorkForce.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobsCollection implements Subject {
    private static final String JOB_HOURS_REMAINING = "Job: %s Hours Remaining: %d";

    private List<Job> jobs;

    public JobsCollection() {
        this.jobs = new ArrayList<>();
    }

    @Override
    public List<Job> getJobs() {
        return Collections.unmodifiableList(this.jobs);
    }

    @Override
    public void registerJob(Job job) {
        this.jobs.add(job);
    }

    @Override
    public void unregisterJob(Job job) {
        this.jobs.remove(job);
    }

    @Override
    public void notifyObserver(Job job) {
        System.out.println(job.toString());
    }

    public void passWeek() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Job job : this.getJobs()) {
            sb.append(String.format(JOB_HOURS_REMAINING, job.getName(), job.getWorkRequiredHours()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
