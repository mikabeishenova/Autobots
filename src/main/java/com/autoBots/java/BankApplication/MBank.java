package com.autoBots.java.BankApplication;

public class MBank extends BankBase {
    private double balabce = 200; // bonus with opening account

    public MBank(String bankName, long accountNumber, long routingNumber) throws Exception {
        super(bankName, accountNumber, routingNumber);
        addToAllBankRecords(this); // добавить созданного пользователя из конструктора
    }

    @Override
    public double getBalance() {
        return balabce;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 200000){
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balabce += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount <0 || amount > 150000){
            throw  new IllegalArgumentException("Invalid amount can not be withDraw");
        } else {
            if (amount > balabce){
                throw new IllegalArgumentException("Insufficient funds");
            } else {
                balabce -= amount;
            }
        }

    }
}
