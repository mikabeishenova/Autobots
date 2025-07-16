package com.autoBots.java.bankApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankProApp {

    static Scanner scanner = new Scanner(System.in);
    private static final Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {

        Client asan = new Client("Asan Usen", "123");

        DepositAccount asanDeppositAccount = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanDeppositAccount);
        asan.addAccount(asanCreditAccount);
        System.out.println(asan.getClientID());

        clients.put(asan.getClientID(), asan);

        System.out.println("============Welcome to MBank==============");
        System.out.print("Enter client ID");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null){
            System.out.println("Client was not found");
            return;
        }
        System.out.print("Enter pin code");
        String pincode = scanner.nextLine();
        if (!client.authenticate(pincode)){
            System.out.println("Wrong pin code");
            return;
        }
        System.out.println("Welcom " + client.getFullName());
        while (true){
            System.out.println("1. View accounts");
            System.out.println("2. Transfer between accounts");
            System.out.println("3. Show check");
            System.out.println("4. Quit the system");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" :
                    for (BankAccount bankAccount : client.getAccounts()){
                        System.out.printf("%s | %s | Balance: %.2f %s\n",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(), bankAccount.getCurrency());
                    }
                    break;
                case "2" :
                    System.out.println("Enter sender account number");
                    String fromID = scanner.nextLine();
                    System.out.println("Enter recipient account number");
                    String toID = scanner.nextLine();
                    System.out.println("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    BankAccount from = findAccount(fromID);
                    BankAccount to = findAccount(toID);
                    if (from != null && to != null){
                        boolean result = BankService.transfer(from, to, amount);
                        System.out.println(result ? "Success!" : "Error transaction");
                    } else {
                        System.out.println("Not found accounts");
                    }
                    break;
                case "3" :
                    for (BankAccount bankAccount : client.getAccounts()){
                        System.out.println("\n == check " + bankAccount.getAccountNumber());
                        for (Transaction transaction : bankAccount.getTransactions()){
                            System.out.println(transaction);
                        }
                    }
                    break;
                case "0" :
                    System.out.println("Exit ...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static BankAccount findAccount(String accountNumber){
        for (Client client : clients.values()){
            for (BankAccount bankAccount : client.getAccounts()){
                if (bankAccount.getAccountNumber().equals(accountNumber)){
                    return bankAccount;
                }
            }
        }
        return null;
    }
}
