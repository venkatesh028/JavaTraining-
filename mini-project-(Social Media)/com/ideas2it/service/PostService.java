package com.ideas2it.service;

import com.ideas2it.model.Post;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PostService {
    private Map<String, List<Post>> userPost = new HashMap<>();
    private List<Post> listOfPost = new ArrayList<>();
    private Post post;
       
    private String postBuilder() {
        StringBuilder postView = new StringBuilder();

        for (Map.Entry<String,List<Post>> contents : userPost.entrySet()) {
            for (int index = 0; index < contents.getValue().size(); index++) {
                postView.append(contents.getKey())
                        .append(contents.getValue().get(index));       
            }                                            
        }
        
        return postView.toString();
    }

    public boolean addComment(String email, String comment,int postNumber) {
        List<Post> postOfUser = userPost.get(email);
        for (int index = 0; index < postOfUser.size(); index++) {
            Post post = postOfUser.get(index);
            if (post.getPostNumber() == postNumber) {
                post.setComment(comment);
                return true;
            } 
        }    
        return false;            
    }
    
    public boolean addLike(String email, int postNumber) {
        List<Post> postOfUser = userPost.get(email);
        for (int index = 0; index < postOfUser.size(); index++) {
            Post post = postOfUser.get(index);
            if (post.getPostNumber() == postNumber) {
                post.setLike();
                return true;
            } 
        }    
        return false;        
    }
    
    public boolean addPost(String email, String quotes) {
        if (userPost.containsKey(email)) { 
            int postNumber = userPost.get(email).size();           
            Post temporaryPost = new Post(postNumber+1,quotes);
            listOfPost.add(temporaryPost);
            userPost.put(email,listOfPost);   
        } else {
            listOfPost = new ArrayList<>();
            int postNumber = 1;
            Post temporaryPost = new Post(postNumber,quotes);
            listOfPost.add(temporaryPost);
            userPost.put(email,listOfPost);             
        }        
        return true;                                            
    }   
     
    public String showPost() {
        return postBuilder();    
    }
    
    public boolean isPostEmpty () {
        if (userPost.isEmpty()) {
            return false;
        }
        return true;          
    }
}