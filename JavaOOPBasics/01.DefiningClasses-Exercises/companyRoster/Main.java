package companyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Department> departments = new HashMap<>();
        int employeesCount = Integer.valueOf(br.readLine());

        for (int index = 0; index < employeesCount; index++) {
            String[] tokens = br.readLine().split("\\s+");
            //Pesho 120.00 Dev Development pesho@abv.bg 28
            String name = tokens[0];
            double salary = Double.valueOf(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee currentEmployee = null;
            if (tokens.length == 4) {
                currentEmployee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                String input = tokens[4];
                try {
                    int age = Integer.valueOf(input);
                    currentEmployee = new Employee(name, salary, position, department, age);
                } catch (Exception e) {
                    currentEmployee = new Employee(name, salary, position, department, input);
                }
            } else {
                String email = tokens[4];
                int age = Integer.valueOf(tokens[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);
            }

            if (!departments.containsKey(department)) {
                Department currentDepartment = new Department();
                departments.putIfAbsent(department, currentDepartment);
            }

            departments.get(department).getEmployees().add(currentEmployee);
        }

        departments.entrySet().stream()
                .sorted((d1, d2) -> {
                    double d1Salary = d1.getValue().getEmployees()
                            .stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    double d2Salary = d2.getValue().getEmployees()
                            .stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    return Double.compare(d2Salary, d1Salary);
                })
                .limit(1)
                .forEach(d -> {
                    System.out.printf("Highest Average Salary: %s%n", d.getKey());
                    d.getValue().getEmployees()
                            .stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> System.out.println(e.toString()));
                });
    }
}
