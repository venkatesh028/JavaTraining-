package com.ideas2it.dao.daoImpl;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.ideas2it.dao.PostDao;
import com.ideas2it.model.Post;

/**
 * Perform add, update and get function for the post
 * 
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public class PostDaoImpl implements PostDao {
    private final static Map<String, List<Post>> userPost;
    
    static {
        userPost = new HashMap<>();
    }
    
    @Override
    public boolean addPost(String userId, List<Post> listOfPost) {
        userPost.put(userId, listOfPost);    
        return true;    
    }
    
    @Override
    public List<Post> getPost(String userNameOfPost) {
        return userPost.get(userNameOfPost);
    }
    
    @Override
    public boolean updatePost(String userNameOfPost, List<Post> listOfPost) {
        userPost.put(userNameOfPost, listOfPost);
        return true;
    }
    
    @Override
    public Map<String, List<Post>> getUserPost() {
        return userPost;
    }
}