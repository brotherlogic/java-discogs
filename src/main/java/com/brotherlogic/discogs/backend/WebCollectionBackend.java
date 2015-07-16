package com.brotherlogic.discogs.backend;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import com.brotherlogic.discogs.Folder;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public class WebCollectionBackend implements CollectionBackend {

  private UrlRetriever retriever;
  private Logger logger = Logger.getLogger(getClass());

  public WebCollectionBackend(UrlRetriever retr) {
    retriever = retr;
  }

  @Override
  public Collection<Folder> getFolders(String username) {
    try {
      JsonElement mainRead = new JsonParser()
          .parse(retriever.get("users/" + username + "/collection/folders"));
      JsonArray folderArray = mainRead.getAsJsonObject()
          .get("folders").getAsJsonArray();

      Type collectionType = new TypeToken<Collection<Folder>>(){}.getType();
      return new Gson().fromJson(folderArray,collectionType);
    } catch (IOException e) {
      logger.log(Level.ERROR,"Cannot read folders for " + username,e);
      return null;
    }
  }
}
