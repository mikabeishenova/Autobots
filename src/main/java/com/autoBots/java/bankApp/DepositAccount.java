package com.autoBots.java.bankApp;

public class DepositAccount extends BankAccount{

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance){
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                ", currency=" + currency +
                ", transactions=" + transactions +
                '}';
    }
}
