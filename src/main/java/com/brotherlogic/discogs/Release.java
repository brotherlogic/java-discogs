package com.brotherlogic.discogs;

public class Release extends DiscogsEntity {
  
  private long id;
  
  public Release(long idValue) {
    id = idValue;
  }
  
  public Long getId() {
    return id;
  }
}
