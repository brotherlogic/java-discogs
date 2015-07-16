package com.brotherlogic.discogs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ForSale extends DiscogsEntity {
  private long id;
  private Condition condition = null;
  private Price salePrice = null;
  
  private static Logger logger = Logger.getLogger(ForSale.class);

  /**
   * Builds a ForSale object with an id, condition and specified price.
   */
  public ForSale(long idVal, Condition cond, Price price) {
    id = idVal;
    condition = cond;
    salePrice = price;
  }
  
  public Condition getCondition() {
    return condition;
  }
  
  public Price getPrice() {
    return salePrice;
  }
}
