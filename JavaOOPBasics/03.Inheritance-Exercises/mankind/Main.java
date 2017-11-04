package mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] studentTokens = br.readLine().split("\\s+");
        String studentFirstName = studentTokens[0];
        String studentLastName = studentTokens[1];
        String studentFacultyNum = studentTokens[2];

        Human student = null;
        try {
            student = new Student(studentFirstName, studentLastName, studentFacultyNum);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        String[] workerTokens = br.readLine().split("\\s+");
        String workerFirstName = workerTokens[0];
        String workerLastName = workerTokens[1];
        double workerWeekSalary = Double.parseDouble(workerTokens[2]);
        double workHoursPerDay = Double.parseDouble(workerTokens[3]);

        Human worker = null;
        try {
            worker = new Worker(workerFirstName, workerLastName, workerWeekSalary, workHoursPerDay);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        System.out.print(student);
        System.out.print(worker);
    }
}
