package com.brotherlogic.discogs;

public class User extends DiscogsEntity {

    private String userName;

    public User(String name) {
	userName = name;
    }

    public String getUserName() {
	return userName;
    }
}