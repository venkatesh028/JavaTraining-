package com.ideas2it.dao;

import java.util.List;
import java.util.Map;

import com.ideas2it.model.Post;

/**
 * Perform add, update and get function for the post
 * 
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public interface PostDao {
  
    /**
     * Add post to the particular user
     *
     * @param  userName   username of the user
     * @param  listOfPost list of post uploaded by the user
     * @return boolean    true after adding the post
     */
    public boolean addPost(String userId, List<Post> listOfPost);

    /**
     * Get the list of post for the particular user
     *  
     * @param  userNameOfPost username of the user who uploaded the post
     * @return listOfPost     post uploaded by the user
     */
    public List<Post> getPost(String userNameOfPost);

    /**
     * Makes the updates in the post it include the like and comment updates
     *
     * @param  userNameOfPost  username of the user who uploaded the post
     * @param  listOfPost      updated list of post
     * @return boolean         true after updated 
     */
    public boolean updatePost(String userNameOfPost, List<Post> listOfPost);
   
   /**
     * Gives the userPost
     * 
     * @return userPost 
     */  
    public Map<String, List<Post>> getUserPost();

}