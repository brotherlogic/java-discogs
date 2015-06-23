package com.brotherlogic.discogs.backend;

import java.util.Collection;

import com.brotherlogic.discogs.Release;
import com.brotherlogic.discogs.User;

public interface WantsBackend {

    Collection<Release> getWants(User user);

}