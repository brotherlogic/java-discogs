package com.brotherlogic.discogs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ForSale extends DiscogsEntity {
    private long id;
    private Condition cond = null;
    private Price salePrice = null;

    private static Logger logger = Logger.getLogger(ForSale.class);

    public ForSale(long idVal, Condition c, Price price) {
	id = idVal;
	cond = c;
	salePrice = price;
    }

    public Condition getCondition() {
	return cond;
    }

    public Price getPrice() {
	return salePrice;
    }
}