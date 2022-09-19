package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.ProfileController;
import com.ideas2it.controller.PostController;

/**
 * Shows the profile page to the user based on the user action
 * it takes toe further pages 
 *
 * @version 1.0 14-SEP-2022
 * @author Vebkatesh TM
 */
public class ProfileView {
    private static final int UPDATE_NAME = 1;
    private static final int UPDATE_USERNAME = 2;
    private static final int UPDATE_BIO = 3;
    private static final int EXIT = 4;
    ProfileController profileController;
    PostController postController;
    Scanner scanner;
     
    public ProfileView() {
        this.profileController = new ProfileController();
        this.postController = new PostController();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Shows the update page 
     *
     * @param userId
     */
    private void updateProfile(int userId) {
        StringBuilder message2 = new StringBuilder();
        int selectedUpdate;
        boolean updatePage = true;
        message2.append("\nEnter ").append(UPDATE_NAME)
               .append(" --> To update name").append("\nEnter ")
               .append(UPDATE_USERNAME).append(" --> To update username ")
               .append("\nEnter ").append(UPDATE_BIO)
               .append(" --> To update Bio ").append("\nEnter ")
               .append(EXIT).append(" --> To exit ");

        
            System.out.print(message2);
            selectedUpdate = scanner.nextInt();         

            switch (selectedUpdate) {
            case UPDATE_NAME:
                System.out.println("Enter your Name :");
                String newName = scanner.next();
                profileController.updateName(userId, newName);                   
                break;
            
            case UPDATE_USERNAME:
                System.out.println("Enter your UserName :");
                String newUserName = scanner.next();
                profileController.updateUserName(userId, newUserName);                
                break;
            
            case UPDATE_BIO:
                System.out.print("Enter your Bio :");
                scanner.nextLine();
                String bio = scanner.nextLine();
                profileController.updateBio(userId, bio);            
                break;

            case EXIT:
                updatePage = false;
                break;

            default:
                updatePage = false;
                break;
            }

        
    }


    /**
     * Shows the profile of the user
     * 
     * @param userId userId of the user
     */
    private void showProfile(int userId) {
        System.out.println(profileController.showProfile(userId));
    }
    
    private void showMyPost(int userId) {
        String userName = profileController.getUserName(userId);
        System.out.println(userName);
        System.out.println(postController.showMyPost("userName"));

        if (postController.isMyPostEmpty(userName)) {
            System.out.println("NO Post Uploaded");
        } else {
            System.out.println(postController.showMyPost("userName"));
        }                  
    }

    /**
     * Shows the profilepage of the user
     * 
     * @param userId userId of the user
     */
    public void displayProfilePage(int userId) {
        int selectedOption;
        final int UPDATE_PROFILE = 1;
        final int DELETE_POST =2;
        final int SHOW_PERSONAL_INFO = 3;
        final int EDIT_PERSONAL_INFO = 4;
        final int EXIT = 5;
        StringBuilder message1 = new StringBuilder();
        message1.append("\nEnter ").append(UPDATE_PROFILE)
               .append(" --> To update Profile").append("\nEnter ")
               .append(DELETE_POST).append("--> To delete the post ")
               .append("\nEnter ").append(SHOW_PERSONAL_INFO)
               .append(" --> To View Personal Details")
               .append("\nEnter ").append(EDIT_PERSONAL_INFO)
               .append(" --> To Edit Personal Details")
               .append("\nEnter ").append(EXIT)
               .append(" --> To Exit");               

    profilePage:
        while (true) {   
            showProfile(userId); 
            //showMyPost(userId);
            System.out.println(message1);
            selectedOption = scanner.nextInt();
            
            switch (selectedOption) { 
            case UPDATE_PROFILE:
                updateProfile(userId);
                break;

            case DELETE_POST:
                //deleteMyPost(userName);
                break;

            case SHOW_PERSONAL_INFO:
               // showPersonalInfo(userName);
                break;

            case EDIT_PERSONAL_INFO:
              //  editPersonalInfo(userName);
                break ; 
           
            case EXIT:
                break profilePage;
            }
        }  
    }


} 
    
