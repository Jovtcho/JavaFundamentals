package companyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}
