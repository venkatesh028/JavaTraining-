package com.ideas2it.controller;

import com.ideas2it.service.PostService;

/**
 * Perform the Add post, like and comment for the user
 * 
 * @version 1.0 14-SEP-2022
 * @author Venkatesh TM
 */
public class PostController {
    PostService postService = new PostService();
    
    /** 
     * Check is the given post is empty 
     * 
     * @return boolean true or false based on the result
     */
    public boolean isPostEmpty() {
        return postService.isPostEmpty();
    }
    
    /**
     * Add the post 
     * 
     * @param  userName userName of the user 
     * @param  quotes   quotes entered by the user
     * @return boolean  true after adding the post
     */
    public boolean addPost(String userName, String quotes) {
        return postService.addPost(userName, quotes);
    }
    
    /**
     * Add like to the post
     * 
     * @param  likedUserName  userName of the user who liked 
     * @param  userNameOfPost userName of the post
     * @param  postNumber    
     * @return boolean        true after adding the like 
     */ 
    public boolean addLike(String likedUserName, String userNameOfPost,
                            int postNumber) {
        return postService.addLike(likedUserName, userNameOfPost, postNumber);
    }
    
    /**
     * Shows the post 
     * 
     * @return Post Post uploaded
     */
    public String showPost() {
        return postService.showPost();
    } 
    
    /**
     * Check post is already uploaded 
     *
     * @param  userName username of the user
     * @return boolean  true or false based on the result
     */ 
    public boolean isMyPostEmpty(String userName) {
        return postService.isMyPostEmpty(userName);    
    }
    
    /**
     * Shows the post of the particular user
     *
     * @param  userName username of the user
     * @return post    post of the particular user
     */
    public String showMyPost(String userName) {
        return postService.showMyPost(userName); 
    }
    
    /**
     * Add the comment to the particular user 
     * 
     * @parma      userName   userName of the post
     * @param      comment    comment for that post
     * @postNumber postNumber postnumber of that post
     * @return     boolean    true after adding the comment 
     */
    public boolean addComment(String userName, String comment, int postNumber) {
        return postService.addComment(userName, comment, postNumber);
    }
    
}
