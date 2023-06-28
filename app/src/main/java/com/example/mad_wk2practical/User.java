package com.example.mad_wk2practical;

public class User {

    public String name;
    public String description;
    public Integer id;
    public boolean followed;

    public User() {
    }

    public User(String name,String description, int id, boolean followed){
        this.name= name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = name;
    }

    public String getPassword() {
        return description;
    }

    public void setPassword(String password) {
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public boolean isFollowed() {
        return followed;
    }
    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}