package com.brotherlogic.discogs.backend;

import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.brotherlogic.discogs.Price;
import com.brotherlogic.discogs.Release;
import com.brotherlogic.discogs.utils.CurrencyConverter;

public class WebPriceBackend implements PriceBackend {

    private URLRetriever retriever;
    private CurrencyConverter converter;

    public WebPriceBackend(URLRetriever retr, CurrencyConverter conv) {
	retriever = retr;
	converter = conv;
    }

    public Price getPrice(Release r) {
	try{
	    JsonElement reply = new JsonParser().parse(retriever.get("marketplace/price_suggestions/" + r.getId()));
	    String currency = "USD";
	    Integer value =  (int)(reply.getAsJsonObject().get("Very Good Plus (VG+)").getAsJsonObject().get("value").getAsDouble() * 100);
	    return new Price(value,currency,converter);
	} catch (IOException e) {
	    return null;
	}
    }
}