package com.brotherlogic.discogs;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.brotherlogic.discogs.web.FileServerInterface;

public class WantsTest {

    @Test
    public void testRetrievedWantsListIsCorrectSize() throws IOException {
	User u = new User("testuser");
	List<Release> wants = u.getWants(new FileServerInterface());
	Assert.assertEquals(wants.size(),44);
    }
}