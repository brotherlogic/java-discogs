package com.brotherlogic.discogs.backend;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import com.brotherlogic.discogs.Release;
import com.brotherlogic.discogs.User;

public class WebWantsBackend implements WantsBackend {

    URLRetriever retriever;
    Paginator paginator;

    public WebWantsBackend(URLRetriever retr, Paginator pager) {
	retriever = retr;
	paginator = pager;
    }

    public Collection<Release> getWants(User u) {
	try{
	    JsonElement mainElement = new JsonParser().parse(retriever.get("users/" + u.getUserName() + "/wants"));
	    JsonArray wantsArray = paginator.unpaginate(mainElement.getAsJsonObject(),"wants");
	    
	    Type collectionType = new TypeToken<List<Release>>(){}.getType();
	    return new Gson().fromJson(wantsArray,collectionType);
	} catch (IOException e) {
	    return null;
	}
    }

}
