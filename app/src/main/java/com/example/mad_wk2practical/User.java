package com.example.mad_wk2practical;

import java.io.Serializable;

public class User implements Serializable {

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
        this.name = userName;
    }

    public String getUserDescription() {
        return description;
    }

    public void setUserDescription(String description) {
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public boolean getIsFollowed() {
        return followed;
    }
    public void setIsFollowed(boolean followed) {
        this.followed = followed;
    }
}