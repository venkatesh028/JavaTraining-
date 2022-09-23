package com.ideas2it.dao;

import java.util.Map;
import java.util.HashMap;

import com.ideas2it.model.User;
import com.ideas2it.model.Profile;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 22-SEP-2022
 * @author  Venkatesh TM
 */
public class UserDao {
    private static Map<String, User> users;
    private static Map<String, String> loginCredentials;
    private User user;

    static {
        users = new HashMap<>();
        loginCredentials = new HashMap<>();
    }

    /**
     * Create account for the user and add with id as key in users
     *  
     * @param  user     details of the user
     * @return boolean  true after adding the user in map
     */
    public boolean createAccount(User user) {
        users.put(user.getUserId(), user);
        loginCredentials.put(user.getEmail(), user.getUserId());
        return true;        
    }


    /** 
     * Delete the account
     * 
     * @param  userId  userId of the user
     * @return boolean true after deleting the account
     */   
    public boolean deleteAccount(String userId) {
        users.remove(userId);
        return true;    
    }
    
    /** 
     * Get the all the users
     * 
     * @return users all the users
     */
    public Map<String, User> getUsers() {
        return users;
    }
    
    /**
     * Get the particular user based on the userId
     * 
     * @param  userId userId of the user
     * @return user   particular userdetails 
     */
    public User getUser(String userId) {
        return users.get(userId);
    }
    
    /**
     * Get the profile of the particular user
     * 
     * @param  userId  userId of the user
     * @return profile profile of the particular user
     */
    public Profile getProfile(String userId) {
        return users.get(userId).getProfile();
    }
    
    /** 
     * Get the loginCredentials of the user
     *
     * @return loginCredentials logincredentials of the user
     */
    public Map<String, String> getLoginCredentials() {
        return loginCredentials;    
    }
   
    /**
     * update name of the user 
     * 
     * @param  userId  userId of the user
     * @param  name    name of the user
     * @return boolean true after the update
     */
    public boolean updateName(String userId, String name) {
        user = users.get(userId);
        user.setName(name);
        return true;
    }
    
    /**
     * update the email of the user
     * 
     * @param  userId  userId of the user
     * @param  email   email ofthe user
     * @return boolean true after update the email
     */
    public boolean updateEmail(String userId, String email) {
        user = users.get(userId);
        user.setEmail(email);
        return true;
    }

    /**
     * update gender of the user
     * 
     * @param  userId  userId of the user
     * @param  gender  gender of the user
     * @return boolean true after updateing
     */
    public boolean updateGender(String userId, String gender) {
        user = users.get(userId);
        user.setGender(gender);
        return true;
    }
    
    /**
     * update dateOfBirth of the user
     * 
     * @param  userId      userId of the user
     * @param  dateOfBirth dateOfBirth  of the user
     * @return boolean     true after updateing
     */
    public boolean updateDateOfBirth(String userId, String dateOfBirth) {
        user = users.get(userId);
        user.setDateOfBirth(dateOfBirth);
        return true;
    }

    /**
     * update phoneNumber of the user
     * 
     * @param  userId      userId of the user
     * @param  phoneNumber phone number of the user
     * @return boolean     true after updateing
     */
    public boolean updatePhoneNumber(String userId, String phoneNumber) {
        user = users.get(userId);
        user.setPhoneNumber(phoneNumber);
        return true;
    }
}