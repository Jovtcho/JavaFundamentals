package StaticIdAndInterest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, BankAccount> accounts = new HashMap<>();

        String line = br.readLine();
        while (!"End".equalsIgnoreCase(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0].toLowerCase();

            switch (command) {
                case "create":
                    createNewAccount(accounts);
                    break;
                case "deposit":
                    depositAmount(accounts, tokens);
                    break;
                case "setinterest":
                    setInterest(tokens);
                    break;
                case "getinterest":
                    getInterest(accounts, tokens);
                    break;
                default:
                    System.out.println("No such command.");
                    break;
            }

            line = br.readLine();
        }
    }

    private static void getInterest(Map<String, BankAccount> accounts, String[] tokens) {
        String currentId = "ID" + tokens[1];
        int years = Integer.valueOf(tokens[2]);
        if (!accounts.containsKey(currentId)) {
            System.out.println("Account does not exist");
            return;
        }

        double interest = accounts.get(currentId).getInterest(years);
        System.out.printf("%.2f%n", interest);
    }

    private static void setInterest(String[] tokens) {
        double currentInterest = Double.valueOf(tokens[1]);
        BankAccount.setInterestRate(currentInterest);
    }

    private static void depositAmount(Map<String, BankAccount> accounts, String[] tokens) {
        String currentId = "ID" + tokens[1];
        double amount = Double.valueOf(tokens[2]);
        if (!accounts.containsKey(currentId)) {
            System.out.println("Account does not exist");
            return;
        }

        accounts.get(currentId).deposit(amount);
        System.out.printf("Deposited %.0f to %s%n", amount, currentId);
    }

    private static void createNewAccount(Map<String, BankAccount> accounts) {
        BankAccount bankAccount = new BankAccount();
        accounts.putIfAbsent(bankAccount.toString(), bankAccount);
        System.out.printf("Account %s created%n", bankAccount.toString());
    }


}
