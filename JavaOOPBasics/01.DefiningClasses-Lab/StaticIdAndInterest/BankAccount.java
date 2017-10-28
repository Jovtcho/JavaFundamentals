package StaticIdAndInterest;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double interestRate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
