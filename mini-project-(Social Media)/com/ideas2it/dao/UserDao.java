package com.ideas2it.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ideas2it.model.User;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 19-SEP-2022
 * @author  Venkatesh TM
 */ 
public class UserDao {
    private static Map<Integer, User> users;
    private static Set<String> userNames;
    private static Map<String, Integer> loginCredentials;
    private User user;

    static {
        users = new HashMap<>();
        userNames = new HashSet<>();
        loginCredentials = new HashMap<>();
    }
    

    /**
     * Create account for the user and add with id as key in users
     *  
     * @param  userName userName of the user
     * @param  user     details of the user
     * @return boolean  true after adding the user in map
     */
    public boolean createAccount(int userId, String userName, User user) {
        users.put(userId, user);
        loginCredentials.put(user.getEmail(), userId);
        userNames.add(userName);
        return true;        
    }
    
    /** 
     * Delete the account
     * 
     * @param userId userId of the user
     */
    public boolean deleteAccount(int userId) {
        users.remove(userId);    
        return true;
    }
    
    /**
     * Pass the loginCredentials 
     *
     * @return loginCredentials 
     */
    public Map<String, Integer> getLoginCredentials() {
        return loginCredentials; 
    }
    
    /**
     * Pass the users
     *
     * @return users 
     */
    public Map<Integer, User> getUsers() {
        return users;
    }    
    
    /**
     * Pass the usernames 
     *
     * @return userNames
     */
    public Set<String> getUserNames() {
        return userNames;
    }
    
}