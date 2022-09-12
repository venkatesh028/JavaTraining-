package com.ideas2it.controller;

import com.ideas2it.service.PostService;

/**
 * It perfoms the adding function of  post , like  and comment
 * and perfoms view function of the post  
 *
 * @version 1.0 09-SEP-2022
 * @author Venkstesh TM
 */
public class PostController {
    private PostService postService = new PostService();
    
    /**
     * Check the post are available or not 
     *
     * @return boolean true if the post is available else false
     */
    public boolean isPostEmpty() {
        return postService.isPostEmpty(); 
    }
    
    /** 
     * Shows the post 
     *
     * @return postService.showPost() gets the post uploaded
     */ 
    public String showPost(){
        return postService.showPost();
    }
    
    /**
     * Add the post to the particular user
     *
     * @param  email   email  of the particular user
     * @param  quotes  quotes quotes entered by the user
     * @return boolean true if the post is added successfully or else false
     * /
    public boolean addPost(String email, String quotes) {
        return postService.addPost(email,quotes);   
    }
    
    /** 
     * Add like to the particular post for the particular user
     *
     * @param  email      email of the user belongs to that post
     * @param  postNumber postNumber of that particular post
     * @return boolean    true if the like is added else flase
     */
    public boolean addLike(String email, int postNumber) {
        return postService.addLike(email,postNumber);    
    }
    
    /**
     * Add comment on the particular post for the particular user
     * 
     * @param  email      email of the user belongs to that post 
     * @parma  comment    comment need to be added
     * @param  postNumber post number of the particular post
     * @return boolena    true if the comment is added else false
     */ 
    public boolean addComment(String email,String comment ,int postNumber) {
        return postService.addComment(email,comment,postNumber) ;   
    }
}