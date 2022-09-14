package com.ideas2it.view;

import com.ideas2it.view.PostView;
//import com.ideas2it.view.ProfileView;

import java.util.Scanner;

public class FeedView {
    private PostView postView;
   // private ProfileView profileView = new ProfileView();
    private Scanner scanner;

    /**
     * Creates a new object for the FeedView and initialize the feilds
     * of that class
     */    
    public FeedView() {
        this.postView = new PostView();
        this.scanner = new Scanner(System.in);
    }
    
    public void showNewsFeed(String userName) {
        int action;
        final int SHOW_POST = 1;
        final int SHOW_PROFILE = 2;
        final int LOGUT = 3;
        StringBuilder statement = new StringBuilder();
        statement.append("Enter ").append(SHOW_POST).append(" To View Post ")
                 .append(SHOW_PROFILE).append(" To view your profile ")
                 .append(LOGUT).append("to Logout");

    newsFeed:
        while(true) {
            System.out.println(statement);
            action = scanner.nextInt();

            switch(action) {
            case SHOW_POST:
                postView.displayPost(userName);
                break;
            
            case SHOW_PROFILE:
               // profileView.displayProfilePage(userName);
                break;
   
            case LOGUT:
                break newsFeed;
            }
        }
                   
    }
}