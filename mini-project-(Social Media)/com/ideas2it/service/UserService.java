package com.ideas2it.service;

import com.ideas2it.model.User;

import java.util.Map;
import java.util.HashMap;

/**
 * Perform the create, delete ,change  and validation
 * Based on the user request 
 *
 * @author Venkatesh TM
 * @version 1.0 08-SEP-2022
 */
public class UserService {
    private Map<String,User> users = new HashMap<>();
    private User user;
    
    /**
     * Add a account to the map with email as a key
     * 
     * @param  key     email of the user 
     * @param  user    Details of the uer
     * @return boolean true if the user is added successfully else false
     */
    public boolean createAccount(String key, User user) {
        if (null == users.putIfAbsent(key,user)) {
            return true;
        }
        return false;
    }
    
    /**
     * Delete the Account of the user based on the email
     *
     * @param  email   email of the user 
     * @return boolean true if the account is deleted else false 
     */
    public boolean deleteAccount(String email) {
        user = users.get(email);        
        return users.remove(email,user);     
    }
    
    /** 
     * Change the email of the user
     * 
     * @param  oldEmail old email of the user 
     * @param  newEmail new email of the user
     * @return boolean  true if the changes is successfully updated
     */
    public boolean changeEmail(String oldEmail, String newEmail) {
        user = users.remove(oldEmail);
        user.setEmail(newEmail);
        if (null == users.put(newEmail, user)) {
            return true;
        }
        return false;
    }
    
    /**
     * Change the name of the user 
     *
     * @param  email   email of the user
     * @param  newName new name entered by the user
     * @return boolean true after changeing the name successfully
     */
    public boolean changeName(String email, String newName) {
        user = users.get(email);
        user.setName(newName);
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
    public boolean changePassword(String email,String oldPassword,
                                      String newPassword) {
        user = users.get(email);
        if (user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
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
        if (users.containsKey(email)) {
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
        user = users.get(email);
 
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}