package com.ides2it.model;

import java.util.ArrayList;

public class Post {
    String quotes;
    int like = 0;
    int postNumber = 0;
    ArrayList<String> comments = new ArrayList<>();
    
    public String getQuotes() {
        return quotes;
    }
   
    public int getLike() {
        return like;
    }
    
    public ArrayList<String> getComments() {
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
    
    public void setComment(String comment) {
        comments.add(comment);
    }
    
    public void setPostNumber() {
        postNumber++;
    }
}