package com.brotherlogic.discogs;

import com.brotherlogic.discogs.utils.CurrencyConverter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Price {
  Integer value;
  String currency;
  CurrencyConverter converter;
  
  private Logger logger = Logger.getLogger(getClass());

  /**
   * Builds a price in a specified currency, with a suppled converter.
   */
  public Price(Integer val, String curr, CurrencyConverter conv) {
    value = val;
    currency = curr;
    converter = conv;
  }

  /**
   * The price in dollars, converting as necessary.
   */
  public Integer getPriceInDollars() {
    double rate = converter.getConversionRate(currency,"USD");
    logger.log(Level.DEBUG,"Converting " + value + " with rate " + rate);
    return new Integer((int)(rate * value));
  }
}
