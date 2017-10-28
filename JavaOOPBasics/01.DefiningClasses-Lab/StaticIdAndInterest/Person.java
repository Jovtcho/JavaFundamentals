package StaticIdAndInterest;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> personalAccounts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.personalAccounts = new ArrayList<>();
    }

    public Person(String name, int age, List<BankAccount> personalAccounts) {
        this(name, age);
        this.personalAccounts = personalAccounts;
    }

    public double getBalance() {
        return this.personalAccounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}
