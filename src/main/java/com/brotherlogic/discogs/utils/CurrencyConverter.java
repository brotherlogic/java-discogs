package com.brotherlogic.discogs.utils;

public interface CurrencyConverter {
  double getConversionRate(String fromCurrency, String toCurrency);
}
