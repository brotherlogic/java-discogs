package com.brotherlogic.discogs;

public interface CurrencyConverter {
    double getConversionRate(String fromCurrency, String toCurrency);
}