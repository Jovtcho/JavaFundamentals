package DefineBankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> accounts = new HashMap<>();

        String line = br.readLine();
        while (!"End".equalsIgnoreCase(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0].toLowerCase();

            switch (command) {
                case "create":
                    createNewAccount(accounts, tokens);
                    break;
                case "deposit":
                    depositAmount(accounts, tokens);
                    break;
                case "withdraw":
                    withdrawAmount(accounts, tokens);
                    break;
                case "print":
                    printAccountBalance(accounts, tokens);
                    break;
                default:
                    System.out.println("No such command.");
                    break;
            }

            line = br.readLine();
        }

        //System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
    }

    private static void printAccountBalance(Map<Integer, BankAccount> accounts, String[] tokens) {
        int id = Integer.valueOf(tokens[1]);

        if (ifAccountNotExist(accounts, id)) {
            System.out.println("Account does not exist");
            return;
        }

        System.out.printf("Account %s, balance %.2f%n", accounts.get(id), accounts.get(id).getBalance());
    }

    private static void withdrawAmount(Map<Integer, BankAccount> accounts, String[] tokens) {
        int id = Integer.valueOf(tokens[1]);
        double amount = Double.valueOf(tokens[2]);

        if (ifAccountNotExist(accounts, id)) {
            System.out.println("Account does not exist");
            return;
        }

        accounts.get(id).withdraw(amount);
    }

    private static void depositAmount(Map<Integer, BankAccount> accounts, String[] tokens) {
        int id = Integer.valueOf(tokens[1]);
        double amount = Double.valueOf(tokens[2]);

        if (ifAccountNotExist(accounts, id)) {
            System.out.println("Account does not exist");
            return;
        }

        accounts.get(id).deposit(amount);
    }

    private static void createNewAccount(Map<Integer, BankAccount> accounts, String[] tokens) {
        int id = Integer.valueOf(tokens[1]);

        if (!accounts.containsKey(id)) {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
            return;
        }

        System.out.println("Account already exists");
    }

    private static boolean ifAccountNotExist(Map<Integer, BankAccount> accounts, int id) {
        if (!accounts.containsKey(id)) {
            return true;
        }
        return false;
    }
}
