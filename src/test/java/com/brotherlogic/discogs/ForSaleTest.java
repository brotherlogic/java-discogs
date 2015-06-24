package com.brotherlogic.discogs;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import com.brotherlogic.discogs.backend.CrashingRetriever;
import com.brotherlogic.discogs.backend.FileRetriever;
import com.brotherlogic.discogs.backend.WebForSaleBackend;
import com.brotherlogic.discogs.utils.CurrencyConverter;

public class ForSaleTest extends BaseTest {
    @Test
    public void testConditionOrdering() {
	List<Condition> conds = new LinkedList<Condition>();
	conds.add(Condition.NM);
	conds.add(Condition.P);
	Collections.sort(conds);

	Assert.assertEquals(Condition.NM,conds.get(0));
	Assert.assertEquals(Condition.P,conds.get(1));
    }

    public void testGetForSale() {
	Release r = new Release(7131058);
	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
        Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	Collection<ForSale> forSales = new WebForSaleBackend(new FileRetriever(),converter).listForSale(r);
	Assert.assertEquals(11,forSales.size());
    }

    @Test
    public void testBadRetrieve() {	
	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	ForSale sale = new WebForSaleBackend(new CrashingRetriever(),converter).getForSale(145001300);
        Assert.assertNull(sale);
    }

    @Test
    public void testConditionRetrieve() {
	Assert.assertEquals(Condition.M,Condition.getCondition("Mint (M)"));
	Assert.assertEquals(Condition.NM,Condition.getCondition("Near Mint (NM or M-)"));
	Assert.assertNull(Condition.getCondition("Made up condition"));
    }

    @Test
    public void testGetSalePrice() {
	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	ForSale sale = new WebForSaleBackend(new FileRetriever(),converter).getForSale(145001300);

	Assert.assertEquals(new Integer(6349), sale.getPrice().getPriceInDollars());
    }    

    @Test
    public void testGetCondition() {
	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	ForSale sale = new WebForSaleBackend(new FileRetriever(),converter).getForSale(145001300);
	Assert.assertEquals(sale.getCondition(),Condition.NM);
    }    
}