package com.brotherlogic.discogs.web;

import java.io.IOException;

import com.google.gson.JsonElement;

public interface WebInterface {
    JsonElement get(String relativePath) throws IOException;
}