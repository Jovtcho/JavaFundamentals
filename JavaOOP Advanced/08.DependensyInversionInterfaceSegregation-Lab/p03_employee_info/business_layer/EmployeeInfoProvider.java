package p03_employee_info.business_layer;


import p03_employee_info.models.Employee;
import p03_employee_info.user_interface.InfoProvider;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {
    private Database database;

    public EmployeeInfoProvider(Database database) {
        this.database = database;
    }

    @Override
    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
