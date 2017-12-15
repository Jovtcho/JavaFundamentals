package P04_DetailPrinter;

import java.util.ArrayList;
import java.util.List;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees) {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee("Pesho");
        Employee manager = new Manager("Gosho", new ArrayList<>());
        Employee engineer = new Engineer("Misho", 100);

        employees.add(employee);
        employees.add(manager);
        employees.add(engineer);

        DetailsPrinter printer = new DetailsPrinter(employees);
        printer.printDetails();
    }
}
