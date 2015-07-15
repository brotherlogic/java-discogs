package com.brotherlogic.discogs.web;

import com.google.gson.JsonElement;

import java.io.IOException;

public interface WebInterface {
  JsonElement get(String relativePath) throws IOException;
}
