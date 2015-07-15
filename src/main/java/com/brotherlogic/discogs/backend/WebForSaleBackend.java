package com.brotherlogic.discogs.backend;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.brotherlogic.discogs.Condition;
import com.brotherlogic.discogs.ForSale;
import com.brotherlogic.discogs.Price;
import com.brotherlogic.discogs.utils.CurrencyConverter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;


public class WebForSaleBackend implements ForSaleBackend {

  private Logger logger = Logger.getLogger(getClass());
  private UrlRetriever retriever;
  private CurrencyConverter converter;

  public WebForSaleBackend(UrlRetriever retr, CurrencyConverter conv) {
    retriever = retr;
    converter = conv;
  }

  /**
   * Gets the for sale object with the given id.
   */
  public ForSale getForSale(long id) {
    try {
      JsonObject details = new JsonParser()
          .parse(retriever.get("marketplace/listings/" + id)).getAsJsonObject();
      logger.log(Level.DEBUG,"Received " + details);
      Condition cond = Condition
          .getCondition(details.get("condition").getAsString());

      Integer salePrice = details.get("price")
          .getAsJsonObject().get("value").getAsInt() * 100;
      String currency = details.get("price")
          .getAsJsonObject().get("currency").getAsString();
      Price price = new Price(salePrice,currency,converter);

      ForSale sale = new ForSale(id,cond,price);
      return sale;
    } catch (IOException e) {
      logger.log(Level.ERROR,"Cannot retrieve sale details",e);
      return null;
    }
  }
}
