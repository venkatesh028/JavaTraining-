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
    
    public boolean isPostEmpty() {
        return postService.isPostEmpty(); 
    }
    
    public String showPost(){
        return postService.showPost();
    }

    public boolean addPost(String email, String quotes) {
        return postService.addPost(email,quotes);   
    }
    
    public boolean addLike(String email, int postNumber) {
        return postService.addLike(email,postNumber);    
    }
    
    public boolean addComment(String email,String comment ,int postNumber) {
        return postService.addComment(email,comment,postNumber) ;   
    }
}