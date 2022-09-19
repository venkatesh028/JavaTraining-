package com.ideas2it.model;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private String userName;
    private String name;
    private int friendsCount;
    private String bio;
    private List<String> friendsNames;
    
    public Profile(String userName, String name) {
        this.userName = userName;
        this.name = name;
        this.friendsCount = 0;
        this.friendsNames = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount() {
        this.friendsCount++;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getFriendsNames() {
        return friendsNames;
    }

    public void setFriendsNames(String friendsNames) {
        this.friendsNames.add(friendsNames);
    }
    
    public String toString() {
        return "\n UserName      : " + userName
               +"\n Name         : " + name
               +"\n Bio          : " + bio
               +"\n friendsCount : " + friendsCount;
    }

    
}
