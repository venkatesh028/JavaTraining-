package com.ideas2it.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Post {
    private String postId;
    private String postedBy;
    private String quotes;
    private int like;
    private Set<String> likedUsers = new HashSet<>();
    private List<String> comments = new ArrayList<>();
    
    public Post(String postId, String postedBy, String quotes) {
        this.postId = postId;
        this.postedBy = postedBy;
        this.quotes = quotes;
        this.like = 0;    
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
    
    public String getPostNumber() {
        return postId;
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
    
    public void setPostNumber(String postId) {
        this.postId = postId;
    }
    
    public String toString() {
        return  "\n"+postId 
               +"\n"+ quotes
               +"\n Likes : " + like 
               +"\n Comments:  " + comments;
    }

}