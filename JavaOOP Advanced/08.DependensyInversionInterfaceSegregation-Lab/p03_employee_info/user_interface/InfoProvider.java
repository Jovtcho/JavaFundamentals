package p03_employee_info.user_interface;

import p03_employee_info.models.Employee;

import java.util.List;

public interface InfoProvider {
    List<Employee> getEmployeesByName();

    Iterable<Employee> getEmployeesBySalary();
}
