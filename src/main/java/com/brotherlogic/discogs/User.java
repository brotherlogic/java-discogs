package com.brotherlogic.discogs;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import com.brotherlogic.discogs.web.WebInterface;

public class User extends DiscogsEntity {

    private String userName;

    public User(String name) {
	userName = name;
    }

    public List<Release> getWants(){
	return new LinkedList<Release>();
    }

    public List<Release> getWants(WebInterface interf) throws IOException {
	JsonElement mainElement = interf.get("users/" + userName + "/wants");
	JsonArray wantsArray = unpaginate(mainElement.getAsJsonObject(),"wants");

	Type collectionType = new TypeToken<List<Release>>(){}.getType();
	return new Gson().fromJson(wantsArray,collectionType);
    }
}