package com.ideas2it.controller;

import com.ideas2it.service.UserService;
import com.ideas2it.model.User;

/**
 * It contains validation method for validating the user details
 *
 * @version 1.0 08-SEP-2022
 * @author Venkatesh TM
 */
public class UserController {
    private UserService userService;
    
    /**
     * Creates a new object for the UserController and initialize the feilds
     * of that class
     */
    public UserController() {
        this.userService = new UserService();
    }
    
    /**
     * Create new account for the user
     *
     * @param  key      email of the user as a key
     * @param  user     details of the user
     * @return boolean  true if account is created successfully else false
     */
    public boolean createAccount(String userName, User user){
        return userService.createAccount(userName, user);
    }
   
    /**
     * Check is that account is exist 
     *
     * @param  email   email of the user
     * @return boolean true if the account is exist else false 
     */
    public boolean isAccountExist(String email) {
        return userService.isAccountExist(email);       
    }
    
    /**
     * Check is the credentials are valid
     *
     * @param  email    email of the user
     * @param  password password of the user
     * @return boolean  true if the credentials are valid else false
     */
    public boolean isValidCredentials(String email, String password) {
        return userService.isValidCredentials(email, password);
    }
    
    /**
     * Check is this a valid email
     * 
     * @param  email   email entered by the user
     * @return boolean true if the eamil is valid else false
     */
    public boolean isValidEmail(String email) {
        return userService.isValidEmail(email);
    }
    
    /**
     * Check is this a valid password
     * 
     * @param  password password entered by the user
     * @return boolean  true if the password is valid
     */   
    public boolean isValidPassword(String password) {
        return userService.isValidPassword(password);
    }
     
    /**
     * Check is the username is exist or not
     * 
     * @param  userName username given by the user
     * @return boolean  true if the name is not exist else false
     */
     public boolean isUsernameExist(String username) {
         return userService.isUsernameExist(username);
     }

    /**
     * Check is the email is already exist or not
     * 
     * @param  email    email given by the user
     * @return boolean  true if the email is not exist else false
     */
     public boolean isEmailExist(String email) {
         return userService.isEmailExist(email);
     }

    /**
     * Delete the user account 
     *
     * @param  email   email of the user to find the account
     * @return booelan true if the account is deleted Successfully else false
     */      
   /* public boolean deleteAccount(String email) {
        return userService.deleteAccount(email);
    }*/
   
    public String getUserId(String email) {
        return userService.getUserId(email);
    }
    
}