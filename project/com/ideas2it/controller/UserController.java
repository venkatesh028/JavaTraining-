package com.ideas2it.controller;

import com.ideas2it.service.UserService;
import com.ideas2it.util.ValidationUtil;
import com.ideas2it.model.User;

/**
 * It contains validation method for validating the user details
 *
 * @version 1.0 08-SEP-2022
 * @author Venkatesh TM
 */
public class UserController {
    private UserService userService;
    private ValidationUtil validationUtil;
    
    /**
     * Creates a new object for the UserController and initialize the feilds
     * of that class
     */
    public UserController() {
        this.userService = new UserService();
        this.validationUtil = new ValidationUtil();
    }
    
    /**
     * Check is this a valid email
     * 
     * @param  email   email entered by the user
     * @return boolean true if the eamil is valid else false
     */
    public boolean isValidEmail(String email) {
        return validationUtil.isValidEmail(email);
    }

    /**
     * Check is that email is exist 
     *
     * @param  email   email of the user
     * @return boolean true if the account is exist else false 
     */
    public boolean isEmailExist(String email) {
        return userService.isEmailExist(email);       
    }

    /**
     * Check is this a valid password
     * 
     * @param  password password entered by the user
     * @return boolean  true if the password is valid
     */   
    public boolean isValidPassword(String password) {
        return validationUtil.isValidPassword(password);
    }
    
    /**
     * Create new account for the user
     *
     * @param  key      email of the user as a key
     * @param  user     details of the user
     * @return boolean  true if account is created successfully else false
     */
    public boolean createAccount(User user){
        return userService.createAccount(user);
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
     * Check is the username is exist or not
     * 
     * @param  userName username given by the user
     * @return boolean  true if the name is not exist else false
     */
     public boolean isUserNameExist(String username) {
         return userService.isUserNameExist(username);
     }


    /**
     * Delete the user account 
     *
     * @param  email   email of the user to find the account
     * @return booelan true if the account is deleted Successfully else false
     */      
    public boolean deleteAccount(String email) {
        return userService.deleteAccount(email);
    }
    
    /** 
     * Gets the userId of the user
     *
     * @param email email of the user
     * @return userId userId of the user
     */
    public String getUserId(String email) {
        return userService.getUserId(email);
    }

    /**
     * Shows the personal info of the user
     *
     * @param  userId userId of the user
     * @return user   user details 
     */   
    public User showPersonalInfo(String userId) {
        return userService.showPersonalInfo(userId);
    }
 
    /**
     * update name of the user
     * 
     * @param  userId  userId of the user
     * @param  name    new name of the user
     * @return boolean true after updateing
     */
    public boolean updateName(String userId, String name) {
        return userService.updateName(userId, name);
    }

    /**
     * update email of the user
     * 
     * @param  userId  userId of the user
     * @param  email   email of the user
     * @return boolean true after updateing
     */   
    public boolean updateEmail(String userId, String email) {
        return userService.updateEmail(userId, email);
    }
   
    /**
     * update gender of the user
     * 
     * @param  userId  userId of the user
     * @param  gender  gender of the user
     * @return boolean true after updateing
     */
    public boolean updateGender(String userId, String gender) {
        return userService.updateGender(userId, gender);
    }
    
    /**
     * update dateOfBirth of the user
     * 
     * @param  userId      userId of the user
     * @param  dateOfBirth dateOfBirth  of the user
     * @return boolean     true after updateing
     */
    public boolean updateDateOfBirth(String userId, String dateOfBirth) {
        return userService.updateDateOfBirth(userId, dateOfBirth);
    }
    
    /**
     * update phoneNumber of the user
     * 
     * @param  userId      userId of the user
     * @param  phoneNumber phone number of the user
     * @return boolean     true after updateing
     */ 
    public boolean updatePhoneNumber(String userId, String phoneNumber) {
        return userService.updatePhoneNumber(userId, phoneNumber);
    }
    
}