package com.autoBots.java.bankApp;

import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime timeStamp = LocalDateTime.now();

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f", timeStamp, type, amount);
    }
}
