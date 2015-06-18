package com.brotherlogic.discogs;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.brotherlogic.discogs.web.FileServerInterface;

public class ReleaseTest {

    @Test
    public void testMedianPrice() throws IOException {
	Release testRelease = new Release(266528);
	Assert.assertEquals(1636,testRelease.getMedianPrice(new FileServerInterface()));
    }
}