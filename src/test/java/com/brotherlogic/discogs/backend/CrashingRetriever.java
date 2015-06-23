package com.brotherlogic.discogs.backend;

import java.io.IOException;

public class CrashingRetriever implements URLRetriever {
    public String get(String relativePath) throws IOException {
	throw new IOException("Cannot retrieve");
    }
}