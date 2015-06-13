package com.brotherlogic.discogs.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FileServerInterface implements WebInterface {

    public JsonElement get(String relativePath) throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader(new File("etc/testdata/" + relativePath.replaceAll("/","."))));
	return new JsonParser().parse(reader);
    }
}