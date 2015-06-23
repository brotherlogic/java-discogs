package com.brotherlogic.discogs.backend;

import java.io.IOException;

public interface URLRetriever {
    
    String get(String relativePath) throws IOException;

}
