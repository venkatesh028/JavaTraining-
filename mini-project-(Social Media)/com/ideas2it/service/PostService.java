package com.ideas2it.service;

import com.ideas2it.model.Post;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/** 
 * Perform the add functionality for post ,like and comment 
 * and also the create a post format to view
 *
 * @version 1.0 12-SEP-2022
 * @author Venkatesh TM
 */
public class PostService {
    private Map<String, List<Post>> userPost = new HashMap<>();
    private List<Post> listOfPost = new ArrayList<>();
    private Post post;
    
    /**
     * Add comment on the particular post of the particular user with the postNumber
     *
     * @param  email      email of the user belongs to that post 
     * @parma  comment    comment need to be added
     * @param  postNumber post number of the particular post
     * @return boolean    true if the comment is added else false 
     */
    public boolean addComment(String email, String comment, int postNumber) {
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
    
    /** 
     * Add like to the particular post for the particular user
     *
     * @param  email      email of the user belongs to that post
     * @param  postNumber postNumber of that particular post
     * @return boolean    true if the like is added else flase
     */ 
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

    /**
     * Add comment on the particular post for the particular user
     * 
     * @param  email      email of the user belongs to that post 
     * @parma  comment    comment need to be added
     * @param  postNumber post number of the particular post
     * @return boolean    true if the comment is added else false
     */
    public boolean addPost(String email, String quotes) {

        if (userPost.containsKey(email)) { 
            int postNumber = userPost.get(email).size();           
            Post temporaryPost = new Post(postNumber+1, quotes);
            listOfPost.add(temporaryPost);
            userPost.put(email, listOfPost);   
        } else {
            listOfPost = new ArrayList<>();
            int postNumber = 1;
            Post temporaryPost = new Post(postNumber, quotes);
            listOfPost.add(temporaryPost);
            userPost.put(email, listOfPost);             
        }        
        return true;                                            
    }   

    /**
     * Shows the post to the user in the certain foramt 
     *
     * @return postForamt shows the post to user in certain format
     */
    public String showPost() {
        StringBuilder postFormat = new StringBuilder();

        for (Map.Entry<String,List<Post>> contents : userPost.entrySet()) {
            for (int index = 0; index < contents.getValue().size(); index++) {
                postView.append(contents.getKey())
                        .append(contents.getValue().get(index));       
            }                                            
        }
        
        return postFormat.toString();  
    }

    /** 
     * Check is the list of post is empty or not 
     *
     * @return boolean true if it is not empty else fasle
     */
    public boolean isPostEmpty () {
        if (userPost.isEmpty()) {
            return false;
        }
        return true;          
    }
}