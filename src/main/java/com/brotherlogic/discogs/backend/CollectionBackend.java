package com.brotherlogic.discogs.backend;

import com.brotherlogic.discogs.Folder;

import java.util.Collection;

public interface CollectionBackend {
  Collection<Folder> getFolders(String username);
}
