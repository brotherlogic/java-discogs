package com.brotherlogic.discogs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import com.brotherlogic.discogs.web.CrashingInterface;
import com.brotherlogic.discogs.web.FileServerInterface;

public class ForSaleTest extends BaseTest {
    @Test
    public void testConditionOrdering() {
	List<ForSale.Condition> conds = new LinkedList<ForSale.Condition>();
	conds.add(ForSale.Condition.NM);
	conds.add(ForSale.Condition.P);
	Collections.sort(conds);

	Assert.assertEquals(ForSale.Condition.NM,conds.get(0));
	Assert.assertEquals(ForSale.Condition.P,conds.get(1));
    }

    @Test
    public void testBadRetrieve() {
	ForSale sale = new ForSale(145001300);
        Assert.assertNull(sale.getCondition(new CrashingInterface()));
    }

    @Test
    public void testConditionRetrieve() {
	Assert.assertEquals(ForSale.Condition.M,ForSale.Condition.getCondition("Mint (M)"));
	Assert.assertEquals(ForSale.Condition.NM,ForSale.Condition.getCondition("Near Mint (NM or M-)"));
	Assert.assertNull(ForSale.Condition.getCondition("Made up condition"));
    }

    @Test
    public void testGetSalePrice() {
	ForSale sale = new ForSale(145001300);

	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	Assert.assertEquals(new Integer(6349), sale.getPrice(new FileServerInterface(),converter));
	Assert.assertEquals(sale.getCondition(new FileServerInterface()), ForSale.Condition.NM);
    }    

    @Test
    public void testGetCondition() {
	ForSale sale = new ForSale(145001300);
	Assert.assertEquals(sale.getCondition(new FileServerInterface()), ForSale.Condition.NM);

	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("GBP","USD")).thenReturn(1.5874);
	Assert.assertEquals(new Integer(6349), sale.getPrice(new FileServerInterface(),converter));
    }    
}