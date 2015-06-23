package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Release;

public class WebReleaseBackend implements ReleaseBackend{

    URLRetriever retriever;

    public WebReleaseBackend(URLRetriever retr) {
	retriever = retr;
    }

    public Release getRelease(long id) {
	return new Release(id);
    }

}