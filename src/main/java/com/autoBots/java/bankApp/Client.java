package com.autoBots.java.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private final String fullName;
    private final String clientID;
    private final String pin;
    private final List<BankAccount> accounts = new ArrayList<>();

    public Client(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;
        this.clientID = String.valueOf(UUID.randomUUID());
    }

    public boolean authenticate(String inputPin){
        return this.pin.equals(pin);
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }
    public String getFullName() {
        return fullName;
    }

    public String getClientID() {
        return clientID;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
