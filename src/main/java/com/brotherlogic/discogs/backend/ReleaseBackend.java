package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Release;

public interface ReleaseBackend {

    Release getRelease(long id);

}