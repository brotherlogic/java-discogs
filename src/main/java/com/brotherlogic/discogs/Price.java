package com.brotherlogic.discogs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.brotherlogic.discogs.utils.CurrencyConverter;

public class Price {
    Integer value;
    String currency;
    CurrencyConverter converter;

    private Logger logger = Logger.getLogger(getClass());

    public Price(Integer val, String curr, CurrencyConverter conv) {
	value = val;
	currency = curr;
	converter = conv;
    }

    public Integer getPriceInDollars() {
	double rate = converter.getConversionRate(currency,"USD");
	logger.log(Level.DEBUG,"Converting " + value + " with rate " + rate);
	return new Integer((int)(rate * value));
    }
}