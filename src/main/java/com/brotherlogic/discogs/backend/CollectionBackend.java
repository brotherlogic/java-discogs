package com.brotherlogic.discogs.backend;

import java.util.Collection;

import com.brotherlogic.discogs.Folder;

public interface CollectionBackend {
    Collection<Folder> getFolders(String username);
}
