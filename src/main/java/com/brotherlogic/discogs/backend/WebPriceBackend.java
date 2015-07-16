package com.brotherlogic.discogs.backend;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.brotherlogic.discogs.Price;
import com.brotherlogic.discogs.Release;
import com.brotherlogic.discogs.utils.CurrencyConverter;

import java.io.IOException;

public class WebPriceBackend implements PriceBackend {

  private UrlRetriever retriever;
  private CurrencyConverter converter;

  public WebPriceBackend(UrlRetriever retr, CurrencyConverter conv) {
    retriever = retr;
    converter = conv;
  }

  /**
   * Gets the price of the supplied release.
   */
  public Price getPrice(Release rel) {
    try {
      JsonElement reply = new JsonParser()
          .parse(retriever.get("marketplace/price_suggestions/" + rel.getId()));
      String currency = "USD";
      Integer value =  (int)(reply.getAsJsonObject()
                             .get("Very Good Plus (VG+)").getAsJsonObject()
                             .get("value").getAsDouble() * 100);
      return new Price(value,currency,converter);
    } catch (IOException e) {
      return null;
    }
  }
}
