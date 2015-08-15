package com.brotherlogic.discogs;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.brotherlogic.discogs.backend.FileRetriever;
import com.brotherlogic.discogs.backend.Paginator;
import com.brotherlogic.discogs.backend.WebWantsBackend;

public class WantsTest { 
  @Test
  public void testRetrievedWantsListIsCorrectSize() throws IOException {
    User u = new User("testuser", 1234);
    Collection<Release> wants = new WebWantsBackend(new FileRetriever(), new Paginator(new FileRetriever())).getWants(u);
    Assert.assertEquals(wants.size(),44);
  }
}
