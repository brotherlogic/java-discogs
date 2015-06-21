package com.brotherlogic.discogs.web;

import java.io.IOException;

import com.google.gson.JsonElement;

public class CrashingInterface implements WebInterface {

    public JsonElement get(String relativePath) throws IOException {
	throw new IOException("Designed to crash");
    }
}