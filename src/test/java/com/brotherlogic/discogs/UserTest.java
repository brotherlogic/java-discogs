package com.brotherlogic.discogs;

import com.brotherlogic.discogs.backend.FileRetriever;
import com.brotherlogic.discogs.backend.UserBackend;
import com.brotherlogic.discogs.backend.WebUserBackend;

import org.junit.Assert;
import org.junit.Test;

public class UserTest extends BaseTest {

    @Test
    public void testUser() {
        UserBackend backend = new WebUserBackend(new FileRetriever());
        User u = backend.getMe();

        Assert.assertEquals("BrotherLogic", u.getUserName());
        Assert.assertEquals(new Integer(150295), u.getId());
    }
}
