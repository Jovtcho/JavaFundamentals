package p03_employee_info.user_interface;

import p03_employee_info.models.Employee;

public interface Formatter {
    String format(Iterable<Employee> employees);
}
