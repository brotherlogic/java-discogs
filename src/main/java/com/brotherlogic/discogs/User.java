package com.brotherlogic.discogs;

public class User extends DiscogsEntity {
  
  private String userName;
  private Integer id;
  
  public User(String name, Integer idNumber) {
    userName = name;
    id = idNumber;
  }
  
  public String getUserName() {
    return userName;
  }

  public Integer getId() {
    return id;
  }
}
