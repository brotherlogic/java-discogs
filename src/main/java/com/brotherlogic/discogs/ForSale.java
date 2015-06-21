package com.brotherlogic.discogs;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import com.brotherlogic.discogs.web.WebInterface;

public class ForSale extends DiscogsEntity {
    private long id;
    private Condition cond = null;
    private Integer salePrice = null;
    private String currency;

    private static Logger logger = Logger.getLogger(ForSale.class);

    public enum Condition {
	M(5), NM(4), VGP(3), VG(2), G(1), P(0);

	int sortOrder;

	Condition(int sOrder) {
	    sortOrder = sOrder;
	}

	public static Condition getCondition(String condStr) {
	    if (condStr.equals("Mint (M)"))
		return M;
	    else if (condStr.equals("Near Mint (NM or M-)"))
		return NM;
	    else {
		logger.log(Level.ERROR,"Unknown condition: " + condStr);
		return null;
	    }
	}
    }

    private Integer convert(String currency, Integer value, CurrencyConverter converter) {
	double conversionRate = converter.getConversionRate(currency,"USD");
	return new Integer((int)(value * conversionRate));
    }

    public ForSale(long idVal) {
	id = idVal;
    }

    public Integer getPrice(WebInterface webInter, CurrencyConverter converter) {
	if (salePrice == null)
	    getDetails(webInter);
	return convert(currency,salePrice,converter);
    }

    public Condition getCondition(WebInterface webInter) {
	if (cond == null)
	    getDetails(webInter);
	return cond;
    }

    private void getDetails(WebInterface webInter) {
	try{
	    JsonObject details = webInter.get("marketplace/listings/" + id).getAsJsonObject();
	    logger.log(Level.DEBUG,"Received " + details);
	    cond = Condition.getCondition(details.get("condition").getAsString());
	    salePrice = details.get("price").getAsJsonObject().get("value").getAsInt() * 100;
	    currency = details.get("price").getAsJsonObject().get("currency").getAsString();
	} catch (IOException e) {
	    logger.log(Level.ERROR,"Cannot retrieve sale details",e);
	}
    }
}