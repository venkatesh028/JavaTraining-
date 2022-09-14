package com.ideas2it.service;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import com.ideas2it.model.User;
import com.ideas2it.util.ValidationUtil;

/**
 * Perform the create, delete ,change  and validation
 * Based on the user request 
 *
 * @author Venkatesh TM
 * @version 1.0 08-SEP-2022
 */
public class UserService {
    private Map<String,User> users;
    private Set<String> userNames;
    private Set<String> emails;
    private Map<String,String> loginCredentials;
    private User user;
    private ValidationUtil validationUtil;

    private String emailFormat;
    private String passwordFormat;

    /**
     * Creates a new object for the UserService and initialize the feilds
     * of that class
     */
    public UserService() {
        this.users = new HashMap<>();
        this.userNames = new HashSet<>();
        this.emails = new HashSet<>();
        this.loginCredentials = new HashMap<>();
        this.validationUtil = new ValidationUtil();
        this.emailFormat = "^[a-zA-Z0-9][a-zA-Z0-9.]{3,30}@"
                           + "[a-zA-Z0-9][a-zA-Z0-9.]{3,}$";
        this.passwordFormat = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"
                                     + "(?=.*[@#$%^&+=])" 
                                     + "(?=\\S+$).{8,20}$";
    }

    /**
     * Add a account to the map with email as a key
     * 
     * @param  userName username of the user 
     * @param  user     Details of the uer
     * @return true     after adding the user details
     */
    public boolean createAccount(String userName, User user) {
        users.put(userName,user);
        userNames.add(userName);
        emails.add(user.getEmail());
        loginCredentials.put(user.getEmail(),user.getPassword());        
        return true; 
    }
    
    /**
     * Delete the Account of the user based on the email
     *
     * @param  userName UserName of the user 
     * @return boolean  true if the account is deleted else false 
     */
    public boolean deleteAccount(String userName) {
        user = users.get(userName);        
        return userNames.remove(userName) && 
               emails.remove(user.getEmail()) &&
               users.remove(userName,user);
                    
    }
    
    /** 
     * Change the email of the user
     * 
     * @param  userName userName of the user 
     * @param  newEmail new email of the user
     * @return boolean  true if the changes is successfully updated
     */
    public boolean changeEmail(String userName, String newEmail) {
        user = users.get(userName);
        emails.remove(user.getEmail());
        user.setEmail(newEmail);
        return emails.add(newEmail);      
    }
    
    /**
     * Change the name of the user 
     *
     * @param  userName   UserName of the user
     * @param  newName new name entered by the user
     * @return boolean true after changeing the name successfully
     */
    public boolean changeName(String userName, String newName) {
        user = users.get(userName);
        user.setName(newName);
        return true;
    }

    /**
     * Change the userName of the user
     * 
     * @param 
    public boolean changeUserName(String userName, String newUserName) {
        user = users.remove(userName);
        users.put(newUserName, user);
        return true;        
    }
    
    /**
     * Change the password of the user
     *
     * @param  email       email of the user
     * @param  oldPassword old password of the user
     * @param  newPassword new password entered by the user
     * @return boolean     true if the password changed successfully else false
     */  
    public boolean changePassword(String userName,String oldPassword,
                                      String newPassword) {
        user = users.get(userName);
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            loginCredentials.put(user.getEmail(),newPassword);
            return true;
        } 
        return false;
    }
    
    /** 
     * check is the account is exist with the email
     *
     * @param  email email entered by the user
     * @return true or false based on the result
     */
    public boolean isAccountExist(String email) {
        if (emails.contains(email)) {
            return true;
        }
        return false;   
    }  
    
    /**
     * Check is the given credentials are valid 
     *
     * @param  email    email entered by the user
     * @param  password password entered by the user
     * @return boolean  true or false based on the result
     */
    public boolean isValidCredentials(String email, String password) {
        String userPassword = loginCredentials.get(email);
        if (userPassword.equals(password)) {
            return true;
        }
        return false;
    }
    
    /**
     * Check is the given UserName is already exist
     * 
     * @param  userName UserName given by the user
     * @return boolean  true if the username added successfully else false
     */
    public boolean isUsernameExist(String userName) {
        return userNames.contains(userName);        
    }

    /**
     * Check is the given email is already exist
     * 
     * @param  email   email given by the user
     * @return boolean true if the username added successfully else false
     */
    public boolean isEmailExist(String email) {
        return emails.contains(email);
    }
    
    public boolean isValidEmail(String email) {
        return validationUtil.isValid(email,emailFormat);
    }
    
    public boolean isValidPassword(String password) {
        return validationUtil.isValid(password,passwordFormat);
    }
}