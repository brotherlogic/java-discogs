package com.brotherlogic.discogs;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

import com.brotherlogic.discogs.backend.FileRetriever;
import com.brotherlogic.discogs.backend.ReleaseBackend;
import com.brotherlogic.discogs.backend.PriceBackend;
import com.brotherlogic.discogs.backend.WebReleaseBackend;
import com.brotherlogic.discogs.backend.WebPriceBackend;
import com.brotherlogic.discogs.utils.CurrencyConverter;

public class ReleaseTest extends BaseTest {

    @Test
    public void testMedianPrice() throws IOException {
	ReleaseBackend rBackend = new WebReleaseBackend(new FileRetriever());
	Release testRelease = rBackend.getRelease(266528);
	
	CurrencyConverter converter = Mockito.mock(CurrencyConverter.class);
	Mockito.when(converter.getConversionRate("USD","USD")).thenReturn(1.0);
	PriceBackend pBackend = new WebPriceBackend(new FileRetriever(), converter);
	Assert.assertEquals(new Integer(1636),pBackend.getPrice(testRelease).getPriceInDollars());
    }
}