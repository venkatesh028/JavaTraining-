package com.ideas2it.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ideas2it.model.Post;
import com.ideas2it.dao.PostDao;

/** 
 * Perform the add functionality for post ,like and comment 
 * and also the create a post format to view
 *
 * @version 1.0 14-SEP-2022
 * @author Venkatesh TM
 */
public class PostService {
    private Map<String, List<Post>> userPost;
    private List<Post> listOfPost;
    private PostDao postDao;
    
    public PostService() {
        this.postDao = new PostDao();
    }
    
    /**
     * Check is the userPost is empty 
     * 
     * @return true or false based on the result
     */
    public boolean isPostEmpty() {
        userPost = postDao.getUserPost();

        if (userPost.isEmpty()) {
            return false;
        }
        return true;  
    }
    
    public boolean isMyPostEmpty(String userName) { 
        listOfPost = postDao.getPost(userName);  
        System.out.println(listOfPost);     
        return userPost.isEmpty();
    }
   
    /**
     * Add post to particular user with userName as a key
     * 
     * @param userName userName of the user
     * @param quotes   post of the user
     */
    public boolean addPost(String userName, String quotes) {

        if (userPost.containsKey(userName)) { 
            int postNumber = userPost.get(userName).size();           
            Post temporaryPost = new Post(postNumber+1, quotes);
            listOfPost.add(temporaryPost);
            postDao.addPost(userName, listOfPost);   
        } else {
            listOfPost = new ArrayList<>();
            int postNumber = 1;
            Post temporaryPost = new Post(postNumber, quotes);
            listOfPost.add(temporaryPost);
            postDao.addPost(userName, listOfPost);             
        }        
        return true; 
    }
    
    /**
     * Add like to the particular post
     *
     * @param likedUserName  name userename of the user who liked
     * @param userNameOfPost username of the post 
     * @parma postNumber     post number of the post
     */
    public boolean addLike(String likedUserName, String userNameOfPost, 
                                                 int postNumber) {

        List<Post> postOfUser = postDao.getPost(userNameOfPost);
        Set<String> likedUsers;

        for (int index = 0; index < postOfUser.size(); index++) {
            Post post = postOfUser.get(index);

            if (post.getPostNumber() == postNumber) {
                likedUsers = post.getLikedUsers();

                if (! likedUsers.contains(likedUserName)) {
                    post.setLike();
                    post.setLikedUsers(likedUserName);
                } else {
                    post.setUnlike();
                }                
                return true;
            } 
        } 
        postDao.updatePost(userNameOfPost, postOfUser);   
        return false;        
    }

    /**
     * Add comment to the post 
     * 
     * @param  userName   username of the post 
     * @param  comment    comment need to added
     * @param  postNumber postNumber to find out which post
     * @return boolean    true after adding the post
     */
    public boolean addComment(String userName, String comment, int postNumber) {
        List<Post> postOfUser = postDao.getPost(userName);

        for (int index = 0; index < postOfUser.size(); index++) {
            Post post = postOfUser.get(index);

            if (post.getPostNumber() == postNumber) {
                post.setComment(comment);
                return true;
            } 
        } 
        postDao.updatePost(userName, postOfUser);
        return false;            
    }
       
    /**
     * Display the post to the user
     * 
     * @return postFormat post in the particular format to display 
     */
    public String showPost() {
        StringBuilder postFormat = new StringBuilder();
        userPost = postDao.getUserPost(); 

        for (Map.Entry<String, List<Post>> contents : userPost.entrySet()) {
            for (int index = 0; index < contents.getValue().size(); index++) {
                postFormat.append("\n").append(contents.getKey())
                        .append(contents.getValue().get(index));       
            }                                            
        }
        
        return postFormat.toString();  
    } 
    
    public String showMyPost(String userName) {
        StringBuilder myPost = new StringBuilder();
        listOfPost = postDao.getPost(userName); 

        for (int index = 0; index < listOfPost.size(); index++) {
            myPost.append("\n").append(listOfPost.get(index));    
        }
        return myPost.toString();        
    }
    
}
