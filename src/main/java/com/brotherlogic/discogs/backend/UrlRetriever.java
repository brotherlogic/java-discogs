package com.brotherlogic.discogs.backend;

import java.io.IOException;

public interface UrlRetriever {
  String get(String relativePath) throws IOException;
}
