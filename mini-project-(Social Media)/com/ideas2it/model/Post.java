package com.ideas2it.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Contain the attributes of the Post
 * Constructor is used to initialize the attributes
 * Getter and setter method is used to update and retrive the attributes
 * toString method is used to return the values
 *
 * @version 1.0 09-SEP-2022
 * @author Venkatesh Tm
 */
 

public class Post {
    String quotes;
    int like = 0;
    int postNumber;
    Set<String> likedUsers = new HashSet<>();
    List<String> comments = new ArrayList<>();
   
    /**
     * Creates a new object for the Post and initialize the feilds
     * of that class
     */
    public Post (int postNumber, String quotes)  {
        this.postNumber = postNumber;
        this.quotes = quotes;
    }

    public String getQuotes() {
        return quotes;
    }
   
    public int getLike() {
        return like;
    }
    
    public Set<String> getLikedUsers() {
        return likedUsers;
    }

    public List<String> getComments() {
        return comments;
    }
    
    public int getPostNumber() {
        return postNumber;
    }
 
    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }
    
    public void setLike() {
        like++;
    }
    
    public void setUnlike() {
        like--;
    }
    
    public void setLikedUsers(String likedUserName) {
        likedUsers.add(likedUserName);
    }

    public void setComment(String comment) {
        comments.add(comment);
    }
    
    public void setPostNumber() {
        postNumber++;
    }
    
    public String toString() {
        return  "\n"+postNumber +" ) " + quotes
               +"\n Likes : " + like 
               +"\n Comments:  " + comments;
    }
}