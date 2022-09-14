package com.ideas2it.view;

import com.ideas2it.controller.UserController;
import com.ideas2it.model.User;
import com.ideas2it.view.FeedView;

import java.util.Scanner;

/**
 * shows the home page to the user based on the user option
 * it takes to the further pages
 *
 * @author Venkatesh TM
 * @version 1.0
 *
 */
public class UserView {

    private UserController userController;
    private FeedView feedView;
    private Scanner scanner;
    
    /**
     * Creates a new object for the UserView and initialize the feilds
     * of that class
     */    
    public UserView() {
        userController = new UserController();
        feedView = new FeedView();
        scanner = new Scanner(System.in);
    }

    /** 
     * Gets the emailId and password from the user
     * and pass data to the validation based on result 
     * values are stored
     */ 
    public void login() {
        String email;
        String password;

    accountExist:
        while (true) {
            System.out.print("Enter your emailId : ");
            email = scanner.next(); 
            System.out.print("Enter your password : ");
            password = scanner.next();
 
            if (userController.isAccountExist(email)) {               
                if (userController.isValidCredentials(email, password)) {
                    feedView.showNewsFeed(email);
                } else {
                    System.out.println("Invalid password try again ");
                }                   
            } else {
                System.out.println("There is no account with this mailID ");
                break accountExist;
            }
        } 
    } 
    
    /**
     * Get the datails from the user
     * and pass the data to the validation and based on result
     * the account is created
     */
    public void createAccount() {
        User user = new User();
        String name;
        String email;
        String password; 
        String userName;       
        System.out.print("Enter your name : ");
        user.setName(scanner.next());      
    
        while (true) {
            System.out.print("Enter your emailId : ");
            email = scanner.next();

            if (userController.isValidEmail(email)) {
                if (!userController.isEmailExist(email)) {
                    user.setEmail(email);
                    break;
                } else {
                    System.out.println("Email Already exist");
                }                
            } else {
                System.out.println("Invalid email format");     
            }  
        }

    
        while (true) {
            System.out.print("Enter your password : ");
            password = scanner.next();
            
            if (userController.isValidPassword(password)) {
                user.setPassword(password);
                break;
            }
            System.out.println("Invalid your password must"
                              + " contain (a-ZA-Z0-9@#$%^&+=) "
                              + "range must be 8-20");                
        }    
        System.out.println("Set user name to keep your account unique");

        while (true) {
            System.out.print("UserName : ");
            userName = scanner.next();
            
            if (!userController.isUsernameExist(userName)) {
                break;    
            } else {
                System.out.println("UserName is already exist Enter a new one");                
            } 
        }          
  
        if (userController.createAccount(userName,user)) {           
            System.out.println("Account Created Succesfully");
            feedView.showNewsFeed(userName);
        } else {
            System.out.println("This email Id is alredy exist");
        }                          
    } 
  
    //Shows the home page to the user
    public void showHomePage(){
        int selectedOption;
        final int CREATE_ACCOUNT =1;
        final int LOGIN = 2;
        final int EXIT = 3;

        StringBuilder statement = new StringBuilder();
        statement.append("Enter ").append(CREATE_ACCOUNT).append(" create a new one ")
                 .append("with ").append(LOGIN).append(" to login ")
                 .append("with ").append(EXIT).append(" to quit : ");
    appRunning:
        while (true) {
            System.out.print(statement);
            selectedOption = scanner.nextInt();
           
            switch (selectedOption) {
            case CREATE_ACCOUNT:
                createAccount();
                break;

            case LOGIN:
                login();
                break;

            case EXIT:
                break appRunning;

            default:
                System.out.println("you entered wrong choice "); 
            }
            
        }
        
    }
}