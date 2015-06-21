package com.brotherlogic.discogs.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FileServerInterface implements WebInterface {

    Logger logger = Logger.getLogger(getClass());

    public JsonElement get(String relativePath) throws IOException {
	if (!new File("etc/testdata/" + relativePath.replaceAll("/",".")).exists()) {
	    logger.log(Level.FATAL,"Test data file for : " + relativePath + " does not exist (" + new File("etc/testdata/" + relativePath.replaceAll("/",".")) + ")");
	    return new JsonObject();
	}

	BufferedReader reader = new BufferedReader(new FileReader(new File("etc/testdata/" + relativePath.replaceAll("/","."))));
	return new JsonParser().parse(reader);
    }
}