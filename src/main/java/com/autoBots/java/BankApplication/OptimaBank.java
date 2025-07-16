package com.autoBots.java.BankApplication;

public class OptimaBank extends BankBase{
    private double balabce = 0; // bonus with opening account

    public OptimaBank(String bankName, long accountNumber, long routingNumber) throws Exception {
        super(bankName, accountNumber, routingNumber);
        addToAllBankRecords(this); // добавить созданного пользователя из конструктора
    }

    @Override
    public double getBalance() {
        return balabce;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount >= 300000){
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balabce += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount <0 || amount >= 250000){
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
