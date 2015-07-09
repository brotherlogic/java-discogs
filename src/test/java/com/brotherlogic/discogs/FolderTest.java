package com.brotherlogic.discogs;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.brotherlogic.discogs.backend.CollectionBackend;
import com.brotherlogic.discogs.backend.FileRetriever;
import com.brotherlogic.discogs.backend.WebCollectionBackend;

public class FolderTest extends BaseTest {

    @Test
    public void testFolderDetails() {
        CollectionBackend cBackend = new WebCollectionBackend(new FileRetriever());
        Collection<Folder> folders = cBackend.getFolders("brotherlogic");

        Assert.assertEquals(14,folders.size());

        int sumSize = 0;
        for(Folder folder : folders)
            sumSize += folder.getCount();
        Assert.assertEquals(3064,sumSize);
    }
}
