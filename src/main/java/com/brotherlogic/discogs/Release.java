package com.brotherlogic.discogs;

import java.io.IOException;

import com.google.gson.JsonElement;

import com.brotherlogic.discogs.web.WebInterface;

public class Release extends DiscogsEntity {

    private long id;

    public Release(long idValue) {
	id = idValue;
    }

    public int getMedianPrice(WebInterface interf) throws IOException {
	//We're going to return the suggested price for VG+
	JsonElement reply = interf.get("marketplace/price_suggestions/" + id);
	return (int)(reply.getAsJsonObject().get("Very Good Plus (VG+)").getAsJsonObject().get("value").getAsDouble() * 100);
    }
}