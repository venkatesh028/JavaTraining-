package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.PostController;
import com.ideas2it.controller.ProfileController; 

/**
 * Shows the news feed page to user and based on is action shows further pages
 *
 * @version 1.0 09-SEP-2022
 * @author Venkatesh TM
 */ 
public class PostView {
    private PostController postController;
    private Scanner scanner;
    private ProfileController profileController;

    /**
     * Creates a new object for the PostView and initialize the feilds
     * of that class
     */ 
    public PostView() {
        this.postController = new PostController();
        this.profileController = new ProfileController();
        this.scanner = new Scanner(System.in);
    }
    
    /** 
     * Add the post by getting the quotes form the user
     * 
     * @param userName userName of the person who is uploading the post
     */ 
    public void addPost(String userName) {
        String quotes;
        scanner.nextLine();
        System.out.print("Enter your quotes : ");
        quotes = scanner.nextLine();

        if (postController.addPost(userName, quotes)) {
            System.out.println("Post added Successfully");
        }        
    }
    
    /** 
     * Add like to the post by getting the details about that post
     * 
     * @param likedUserName userName of the person who liked the post
     */
    public void addLike(String likedUserName) {
        scanner.nextLine();
        System.out.print("Enter the UserName of the post : ");
        String userNameOfPost = scanner.nextLine();
        System.out.println("Enter the post number : ");
        int postNumber = scanner.nextInt();        
        postController.addLike(likedUserName, userNameOfPost, postNumber);                   
    }
    
    /**
     * Add comment to the post be getting the details about that post
     */
    public void addComment() {
        scanner.nextLine();
        System.out.print("Enter the UserName of the post : ");
        String userName = scanner.nextLine();
        System.out.print("Enter the post number : ");
        int postNumber = scanner.nextInt();   
        scanner.nextLine();
        System.out.print("Enter your comment : ");
        String comment = scanner.nextLine();

        if (postController.addComment(userName, comment, postNumber)) {
            System.out.println("Comment added successfully ");
        }       
    }
    
    /**
     * Shows the post to the user and also provide the option to
     * Add post, like and comment 
     *
     * @param email email of the user who is in this page
     */
    public void displayPost(int userId) {      
        String userName = profileController.getUserName(userId);
        StringBuilder statement = new StringBuilder();
        int action;
        final int ADDPOST = 1;
        final int LIKE = 2;
        final int COMMENT = 3;
        final int EXIT = 4;
        boolean postFeedRunning = true;
        statement.append("\nEnter ").append(ADDPOST)
                 .append(" --> To add post ").append("\nEnter ")
                 .append(LIKE).append(" --> To add like ")
                 .append("\nEnter ").append(COMMENT)
                 .append(" --> To add comment ")
                 .append("\nEnter ").append(EXIT)
                 .append(" --> To exit post feed : ");
    
        while (postFeedRunning) {        
            if (postController.isPostEmpty()) {
                System.out.println(postController.showPost());    
            } else {
                System.out.println("Post is not available");
            } 
            
            System.out.println(statement);
            action = scanner.nextInt();
            
            switch (action) {
            case ADDPOST:
                addPost(userName);
                break;

            case LIKE:
                addLike(userName);
                break;

            case COMMENT:
                addComment();
                break;

            case EXIT:
                postFeedRunning = false;
                break;

            default:
                System.out.println("You entered wrong option");

            }    
        }
    }
}