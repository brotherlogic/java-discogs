package com.brotherlogic.discogs.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FileRetriever implements UrlRetriever {

    private Logger logger = Logger.getLogger(getClass());

    public String get(String relativePath) throws IOException {
	if (!new File("etc/testdata/" + relativePath.replaceAll("/",".")).exists()) {
	    logger.log(Level.FATAL,"Test data file for : " + relativePath + " does not exist (" + new File("etc/testdata/" + relativePath.replaceAll("/",".")) + ")");
	    return "";
	}
	
	BufferedReader reader = new BufferedReader(new FileReader(new File("etc/testdata/" + relativePath.replaceAll("/","."))));
	StringBuffer buffer = new StringBuffer();
	for(String line = reader.readLine() ; line != null ; line = reader.readLine()) {
	    buffer.append(line + "\n");
	}
	return buffer.toString();
    }
}
