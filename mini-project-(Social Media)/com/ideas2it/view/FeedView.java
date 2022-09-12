package com.ideas2it.view;

import com.ideas2it.view.PostView;
//import com.ideas2it.view.ProfileView;

import java.util.Scanner;

public class FeedView {
    private PostView postView = new PostView();
  //  private ProfileView profileView = new ProfileView();
    private Scanner scanner = new Scanner(System.in);
    
    public void showNewsFeed(String email) {
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
                postView.displayPost(email);
                break;
            
            case SHOW_PROFILE:
                //profileView.displyProfile(email);
                break;
   
            case LOGUT:
                break newsFeed;
            }
        }
                   
    }
}