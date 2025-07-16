package com.autoBots.java.bankApp;

import java.util.Map;

public class ExchangeRate {
    public static double convert(double amount, Currency from, Currency to) {
        if (from == to) return amount;

        Map<Currency, Double> toUSD = Map.of(
                Currency.USD, 1.0,
                Currency.EUR, 1.1,
                Currency.KGS, 0.011
        );
        //           100eur * 1.1 = $110
        double usd = amount * toUSD.get(from);
        //     $110 / 0.011 = 10000 som
        return usd / toUSD.get(to);
    }
}
