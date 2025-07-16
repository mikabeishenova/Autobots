package com.autoBots.java.BankApplication;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BankBase implements Bank{
    private long accountNumber;
    private long routingNumber;
    private String bankName;


    public static Set<BankBase> allBankRecords = new HashSet<>();
    // Сделать отдельную базу данных по каждому банку
    // Сгруппировать все банки в Map

    public BankBase(String bankName, long accountNumber, long routingNumber) {
        if (bankName.equals("MBank") || bankName.equals("OptimaBank") || bankName.equals("DemirBank")){

            if (Long.toString(accountNumber).length() != 12) {
                throw new IllegalArgumentException("Account number must be 12 digits");
            } else if (Long.toString(routingNumber).length() != 9) {
                throw new IllegalArgumentException("Routing number must be 9 digits");
            } else {
                this.accountNumber = accountNumber;
                this.routingNumber = routingNumber;
                this.bankName = bankName;
            }
        }
    }

    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase bankBase : allBankRecords){
           if (bankBase.getAccountNumber() == bank.getAccountNumber()){
               throw new Exception(bank.getAccountNumber() + ": Account number already exist");
           }
            if (bankBase.getRoutingNumber() == bank.getRoutingNumber()){
                throw new Exception(bank.getRoutingNumber() + ": Routing number already exist");
            }
            if (!(bankBase.getBankName().equals(("MBank")) || bankBase.getBankName().equals("OptimaBank") || bankBase.getBankName().equals("DemirBank"))){
                throw new Exception(bank.getRoutingNumber() + ": Not valid bank name");
            }
        }
        allBankRecords.add(bank);
    }

    public static List BankRecordsByName(String bankName){
        List<BankBase> bankBasesByName = allBankRecords.stream().filter(bankBase -> bankBase.bankName.equals(bankName)).collect(Collectors.toList());
        return bankBasesByName;
    }

    public static void allBankRecordsByName(){
        Map<String, List<BankBase>> allBankBaseByName = new HashMap<>();

        for (BankBase bank : allBankRecords) {
            String bankName = bank.getBankName();
            allBankBaseByName.computeIfAbsent(bankName, k -> new ArrayList<>()).add(bank);
        }
        System.out.println(allBankBaseByName);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BankBase bankBase)) return false;
        return getAccountNumber() == bankBase.getAccountNumber() && getRoutingNumber() == bankBase.getRoutingNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);// чтобы при сравнении элементы сравнивались по значениям, а не по хеш кодам
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
