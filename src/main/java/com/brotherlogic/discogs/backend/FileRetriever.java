package com.brotherlogic.discogs.backend;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileRetriever implements UrlRetriever {

  private Logger logger = Logger.getLogger(getClass());

  @Override
  public String get(String relativePath) throws IOException {
    InputStream is = getClass().getResourceAsStream(relativePath.replaceAll("/","."));
    if (is == null) {
      logger.log(Level.FATAL,"Test data file for : "
                 + relativePath
                 + " does not exist ("
                 + new File("etc/testdata/"
                            + relativePath.replaceAll("/",".")) + ")");
      return "";
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuffer buffer = new StringBuffer();
    for (String line = reader.readLine(); line != null; line = reader.readLine()) {
      buffer.append(line + "\n");
    }
    return buffer.toString();
  }
}
