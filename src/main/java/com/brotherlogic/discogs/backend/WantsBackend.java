package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Release;
import com.brotherlogic.discogs.User;

import java.util.Collection;

public interface WantsBackend {
  Collection<Release> getWants(User user);
}
