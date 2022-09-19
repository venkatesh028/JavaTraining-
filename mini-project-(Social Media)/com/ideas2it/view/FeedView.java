package com.ideas2it.view;

import java.util.Scanner;

/**
 * Shows the feed page to user based on the user action
 * It takes to the further pages 
 */
public class FeedView {
    private PostView postView;
    private ProfileView profileView;
    private Scanner scanner;

    /**
     * Creates a new object for the FeedView and initialize the feilds
     * of that class
     */    
    public FeedView() {
        this.postView = new PostView();
        this.scanner = new Scanner(System.in);
        this.profileView = new ProfileView();
    }
    
    /**
     * Shows the newsfeed page
     *
     * @param userId
     */
    public void showNewsFeed(int userId) {
        int action;
        final int SHOW_POST = 1;
        final int SHOW_PROFILE = 2;
        final int LOGUT = 3;
        boolean newsFeedRunning = true;
        StringBuilder statement = new StringBuilder();
        statement.append("\nEnter ").append(SHOW_POST)
                 .append(" --> To View Post ").append("\nEnter ")
                 .append(SHOW_PROFILE).append(" --> To view your profile ")
                 .append("\nEnter ").append(LOGUT).append(" --> To Logout");

    
        while (newsFeedRunning) {
            System.out.println(statement);
            action = scanner.nextInt();
            
            switch (action) {
            case SHOW_POST:
                postView.displayPost(userId);
                break;
            
            case SHOW_PROFILE:
                scanner.nextLine();
                profileView.displayProfilePage(userId);
                //postView.displayMyPost(userName);
                break;
   
            case LOGUT:
                newsFeedRunning = false;
                break;
            }
        }
                   
    }
}