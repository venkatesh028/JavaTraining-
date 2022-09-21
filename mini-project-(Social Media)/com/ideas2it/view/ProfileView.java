package com.ideas2it.view;

import java.util.Scanner;

import com.ideas2it.controller.ProfileController;
import com.ideas2it.controller.PostController;
import com.ideas2it.constant.Constants;

/**
 * Shows the profile page to the user based on the user action
 * it takes toe further pages 
 *
 * @version 1.0 14-SEP-2022
 * @author Vebkatesh TM
 */
public class ProfileView {

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
    private void updateProfile(String userId) {
        StringBuilder updateMessage = new StringBuilder();
        int selectedUpdate;
        boolean updatePage = true;
        updateMessage.append("\nEnter ").append(Constants.UPDATE_NAME)
               .append(" --> To update name").append("\nEnter ")
               .append(Constants.UPDATE_USERNAME)
               .append(" --> To update username ")
               .append("\nEnter ").append(Constants.UPDATE_BIO)
               .append(" --> To update Bio ").append("\nEnter ")
               .append(Constants.EXIT_UPDATEPAGE)
               .append(" --> To exit ");

        while (updatePage) {
            System.out.print(updateMessage);
            selectedUpdate = scanner.nextInt();         

            switch (selectedUpdate) {
            case Constants.UPDATE_NAME:
                System.out.println("Enter your Name :");
                String newName = scanner.next();
                profileController.updateName(userId, newName);                   
                break;
            
            case Constants.UPDATE_USERNAME:
                System.out.println("Enter your UserName :");
                String newUserName = scanner.next();
                profileController.updateUserName(userId, newUserName);                
                break;
            
            case Constants.UPDATE_BIO:
                System.out.print("Enter your Bio :");
                scanner.nextLine();
                String bio = scanner.nextLine();
                profileController.updateBio(userId, bio);            
                break;

            case Constants.EXIT_UPDATEPAGE:
                updatePage = false;
                break;

            default:
                updatePage = false;
                break;
            }
        }

        
    }


    /**
     * Shows the profile of the user
     * 
     * @param userId userId of the user
     */
    private void showProfile(String userId) {
        System.out.println(profileController.showProfile(userId));
    }
    
    private void showMyPost(String userId) {
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
    public void displayProfilePage(String userId) {
        int selectedOption;
        StringBuilder profileMessage = new StringBuilder();
        profileMessage.append("\nEnter ").append(Constants.UPDATE_PROFILE)
                      .append(" --> To update Profile").append("\nEnter ")
                      .append(Constants.DELETE_POST).append("--> To delete the post ")
                      .append("\nEnter ").append(Constants.SHOW_PERSONAL_INFO)
                      .append(" --> To View Personal Details")
                      .append("\nEnter ").append(Constants.EDIT_PERSONAL_INFO)
                      .append(" --> To Edit Personal Details")
                      .append("\nEnter ").append(Constants.EXIT_PROFILEPAGE)
                      .append(" --> To Exit");               

    profilePage:
        while (true) {   
            showProfile(userId); 
            //showMyPost(userId);
            System.out.println(profileMessage);
            selectedOption = scanner.nextInt();
            
            switch (selectedOption) { 
            case Constants.UPDATE_PROFILE:
                updateProfile(userId);
                break;

            case Constants.DELETE_POST:
                //deleteMyPost(userName);
                break;

            case Constants.SHOW_PERSONAL_INFO:
               // showPersonalInfo(userName);
                break;

            case Constants.EDIT_PERSONAL_INFO:
              //  editPersonalInfo(userName);
                break ; 
           
            case Constants.EXIT_PROFILEPAGE:
                break profilePage;
            }
        }  
    }


} 
    
