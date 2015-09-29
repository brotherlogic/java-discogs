package com.brotherlogic.discogs.backend;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BasicUrlRetriever implements UrlRetriever {

  private String persToken;
  private static final String DISCOGS_URL = "https://api.discogs.com/";
  private static final String USER_AGENT = "made_up";
  
  private Logger logger = Logger.getLogger(getClass());
  
  public BasicUrlRetriever(String token) {
    persToken = token;
  }

  /**
   * Gets a URL and adds the personal token.
   *
   * @param relativePath the path to retrieve
   * @return The text of the relative path
   */
  
  public String get(String relativePath) throws IOException {
    String url = DISCOGS_URL + relativePath + "?token=" + persToken;
    logger.log(Level.DEBUG, "Retrieving " + url);
    URLConnection connection = new URL(url).openConnection();
    connection.setRequestProperty("User-Agent", USER_AGENT);

    connection.connect();
    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuffer sb = new StringBuffer();
    for (String line = reader.readLine() ; line != null ; line = reader.readLine()) {
      sb.append(line);
    }
    reader.close();

    return sb.toString();
  }
  
}
