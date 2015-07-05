package com.brotherlogic.discogs.backend;

import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.brotherlogic.discogs.User;

public class WebUserBackend implements UserBackend {

    private URLRetriever retriever;
    private Logger logger = Logger.getLogger(getClass());
    
    public WebUserBackend(URLRetriever retr) {
        retriever = retr;
    }
    
    @Override
    public User getMe() {
        try {
            JsonElement user = new JsonParser().parse(retriever.get("oauth/identity"));
            return new User(user.getAsJsonObject().get("username").getAsString());
        } catch (IOException e) {
            logger.log(Level.ERROR,"Cannot retrieve user",e);
        }

        return null;
    }
}
