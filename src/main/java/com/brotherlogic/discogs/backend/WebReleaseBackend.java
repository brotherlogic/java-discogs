package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Release;

public class WebReleaseBackend implements ReleaseBackend{

  private UrlRetriever retriever;

  public WebReleaseBackend(UrlRetriever retr) {
    retriever = retr;
  }

  public Release getRelease(long id) {
    return new Release(id);
  }

}
