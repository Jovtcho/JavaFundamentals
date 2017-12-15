package p03_employee_info;

import p03_employee_info.business_layer.ConsoleFormatter;
import p03_employee_info.business_layer.Database;
import p03_employee_info.business_layer.EmployeeInfoProvider;
import p03_employee_info.data_layer.EmployeeDatabase;
import p03_employee_info.user_interface.ConsoleClient;
import p03_employee_info.user_interface.Formatter;
import p03_employee_info.user_interface.InfoProvider;

public class Main {

    public static void main(String[] args) {
        Database database = new EmployeeDatabase();
        InfoProvider employeeInfo = new EmployeeInfoProvider(database);
        Formatter formatter = new ConsoleFormatter();

        ConsoleClient consoleClient = new ConsoleClient(formatter, employeeInfo);

        System.out.println(consoleClient.getResult());
    }
}
