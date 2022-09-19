package com.ideas2it.dao;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.ideas2it.model.Post;

/**
 * Perform add, update and get function for the post
 * 
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public class PostDao {
    private final static Map<String, List<Post>> userPost;
    
    static {
        userPost = new HashMap<>();
    }
  
    /**
     * Add post to the particular user
     *
     * @param  userName   username of the user
     * @param  listOfPost list of post uploaded by the user
     * @return boolean    true after adding the post
     */
    public boolean addPost(String userName, List<Post> listOfPost) {
        userPost.put(userName, listOfPost);    
        return true;    
    }
    
    /**
     * Get the list of post for the particular user
     *  
     * @param  userNameOfPost username of the user who uploaded the post
     * @return listOfPost     post uploaded by the user
     */
    public List<Post> getPost(String userNameOfPost) {
        return userPost.get(userNameOfPost);
    }
    
    /**
     * Makes the updates in the post it include the like and comment updates
     *
     * @param  userNameOfPost  username of the user who uploaded the post
     * @param  listOfPost      updated list of post
     * @return boolean         true after updated 
     */
    public boolean updatePost(String userNameOfPost, List<Post> listOfPost) {
        userPost.put(userNameOfPost, listOfPost);
        return true;
    }
    
    /**
     * Gives the userPost
     * 
     * @return userPost 
     */  
    public Map<String, List<Post>> getUserPost() {
        return userPost;
    }
}