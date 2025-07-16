package com.autoBots.java.BankApplication;

public class DemirBank extends BankBase{
    private double balabce = 500; // bonus with opening account

    public DemirBank(String bankName, long accountNumber, long routingNumber) throws Exception {
        super(bankName, accountNumber, routingNumber);
        addToAllBankRecords(this); // добавить созданного пользователя из конструктора
    }

    @Override
    public double getBalance() {
        return balabce;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount >= 500000){
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balabce += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount <0 || amount >= 450000){
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
