package com.autoBots.java.bankApp;

public class BankService {
    public static boolean transfer(BankAccount from, BankAccount to, double amount){
        if (from.withdraw(amount)){
            double convertedSum = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());
            to.deposit(convertedSum);
            from.addTransaction("Transfer out", amount);
            to.addTransaction("Transfer in", convertedSum);
            return true;
        }
        return false;
    }
}
