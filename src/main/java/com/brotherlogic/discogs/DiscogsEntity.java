package com.brotherlogic.discogs;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public abstract class DiscogsEntity {
  
  protected JsonArray unpaginate(JsonObject object, String contentIdentifier) {
    return unpaginateSynchronous(object,contentIdentifier);
  }
  
  private JsonArray unpaginateSynchronous(JsonObject object, String contentIdentifier) {
    JsonArray base = object.get(contentIdentifier).getAsJsonArray();
    JsonObject pagObj = object.get("pagination").getAsJsonObject();
    
    return base;
  }
}
