package com.ideas2it.view;

import com.ideas2it.controller.PostController;

import java.util.Scanner;

/**
 * Shows the news feed page to user and based on is action shows further pages
 *
 * @version 1.0 09-SEP-2022
 * @author Venkatesh TM
 */ 
public class PostView {
    private PostController postController = new PostController();
    private Scanner  scanner = new Scanner(System.in);
    
    /**
     * Add the post by getting the quotes form the user
     *
     * @param email  email of the person who is uploading the post
     * /
    public void addPost(String email) {
        String quotes;
        scanner.nextLine();
        System.out.print("Enter your quotes : ");
        quotes = scanner.nextLine();
        if (postController.addPost(email, quotes)){
            System.out.println("Post added Successfully");
        }        
    }
    
    /** 
     * Add like to the post by getting the details about that post
     */
    public void addLike() {
        scanner.nextLine();
        System.out.print("Enter the email of the post : ");
        String emailOfPost = scanner.nextLine();
        System.out.println("Enter the post number : ");
        int postNumber = scanner.nextInt();
        postController.addLike(emailOfPost, postNumber);                   
    }
    
    /**
     * Add comment to the post be getting the details about that post
     */
    public void addComment() {
        scanner.nextLine();
        System.out.print("Enter the email of the post : ");
        String emailOfPost = scanner.nextLine();
        System.out.print("Enter the post number : ");
        int postNumber = scanner.nextInt();   
        scanner.nextLine();
        System.out.print("Enter your comment : ");
        String comment = scanner.nextLine();
        if (postController.addComment(emailOfPost, comment, postNumber)) {
            System.out.println("Comment added successfully ");
        }       
    }
    
    /**
     * Shows the post to the user and also provide the option to
     * Add post, like and comment 
     *
     * @param email email of the user who is in this page
     */
    public void displayPost(String email) {    
        StringBuilder statement = new StringBuilder();
        int action;
        final int ADDPOST = 1;
        final int LIKE = 2;
        final int COMMENT = 3;
        final int EXIT = 4;
        statement.append("Enter ").append(ADDPOST).append(" to add post ")
                 .append(LIKE).append(" to add like ").append(COMMENT)
                 .append(" to add comment ").append(EXIT)
                 .append(" to exit post feed : ");
    newsFeed:
        while (true) {        
            if (postController.isPostEmpty()) {
                System.out.println(postController.showPost());    
            } else {
                System.out.println("Post is not available");
            } 
            
            System.out.print(statement);
            action = scanner.nextInt();
            
            switch (action) {
            case ADDPOST:
                addPost(email);
                break;

            case LIKE:
                addLike();
                break;

            case COMMENT:
                addComment();
                break;

            case EXIT:
                break newsFeed;

            default:
                System.out.println("You entered wrong option");

            }    
        }
    }
}