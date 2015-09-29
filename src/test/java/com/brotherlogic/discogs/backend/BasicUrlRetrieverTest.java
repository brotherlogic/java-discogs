package com.brotherlogic.discogs.backend;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import com.brotherlogic.discogs.BaseTest;

public class BasicUrlRetrieverTest extends BaseTest {

  @Test
  public void testRetrieve() throws IOException {
    BasicUrlRetriever ret = new BasicUrlRetriever("testtoken");
    String res = ret.get("releases/249504");
    Assert.assertTrue(res.length() > 0);
  }
  
}
