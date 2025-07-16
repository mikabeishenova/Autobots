package com.autoBots.java.BankApplication;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank aliyaMbank = new MBank("MBank",123456789123L, 123456789);
        MBank asylMbank = new MBank("MBank",123456788123L, 123456774);
        MBank lizaMbank = new MBank("MBank",723456789189L, 123456763);

        aliyaMbank.deposit(100000);
        OptimaBank ulukOptima = new OptimaBank("OptimaBank",123456789222L, 123458833);
        OptimaBank kolyaOptima = new OptimaBank("OptimaBank",123456789274L, 123458855);
        OptimaBank vasyaOptima = new OptimaBank("OptimaBank",123456789211L, 123458889);

        Bank.transferFunds(aliyaMbank, ulukOptima, 500);


        DemirBank zinaDemir = new DemirBank("DemirBank", 456789456123L, 127758889);
        DemirBank milaDemir = new DemirBank("DemirBank", 456789456155L, 127758879);
        DemirBank gulyaDemir = new DemirBank("DemirBank", 456789456133L, 127758489);
        zinaDemir.deposit(10000);
        zinaDemir.withDraw(1000);

        BankBase.allBankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);
        System.out.println(aliyaMbank.getBalance());
        System.out.println(ulukOptima.getBalance());
        System.out.println(zinaDemir.getBalance());

        double allSumOfBanks = BankBase.allBankRecords.stream().mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfBanks);
        System.out.println("-----------------");
        System.out.println(BankBase.allBankRecords);
        System.out.println("-----------------");

        System.out.println(BankBase.BankRecordsByName("MBank"));
        System.out.println(BankBase.BankRecordsByName("OptimaBank"));
        System.out.println(BankBase.BankRecordsByName("DemirBank"));
        System.out.println("-----------------");

        BankBase.allBankRecordsByName();

    }
}
