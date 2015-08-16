package com.brotherlogic.discogs.backend;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileRetrieverTest {

  @Test
  public void testGetFail() throws IOException {
    FileRetriever f = new FileRetriever();
    Assert.assertEquals("",f.get("/madeuppath"));
  }
}
