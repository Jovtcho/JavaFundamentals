package p04_WorkForce;

import p04_WorkForce.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Employee> employees = new LinkedHashMap<>();
        Subject allJobs = new JobsCollection();
        List<Job> allDoneJobs = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if ("End".equalsIgnoreCase(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");

            Employee employee = null;
            Job job = null;

            switch (tokens[0].toLowerCase()) {
                case "standartemployee":
                    employee = new StandartEmployee(tokens[1]);
                    employees.put(tokens[1], employee);
                    break;
                case "parttimeemployee":
                    employee = new PartTimeEmployee(tokens[1]);
                    employees.put(tokens[1], employee);
                    break;
                case "job":
                    if (employees.containsKey(tokens[3])) {
                        job = new JobImpl(tokens[1], Integer.parseInt(tokens[2]), employees.get(tokens[3]));
                    }
                    allJobs.registerJob(job);
                    break;
                case "pass":
                    for (Job registeredJob : allJobs.getJobs()) {
                        registeredJob.update();
                        if (registeredJob.isFinished()) {
                            allJobs.notifyObserver(registeredJob);
                            allDoneJobs.add(registeredJob);
                        }
                    }
                    unregisterDoneJobs(allJobs, allDoneJobs);
                    break;
                case "status":
                    System.out.println(allJobs.toString());
                    break;
            }
        }
    }

    private static void unregisterDoneJobs(Subject allJobs, List<Job> allDoneJobs) {
        for (Job doneJob : allDoneJobs) {
            allJobs.unregisterJob(doneJob);
        }
    }
}
