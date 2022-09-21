package com.ideas2it.dao;

import java.util.Map;
import java.util.Set;

import com.ideas2it.model.User;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 19-SEP-2022
 * @author  Venkatesh TM
 */
public interface UserDao {

    /**
     * Create account for the user and add with id as key in users
     *  
     * @param  userName userName of the user
     * @param  user     details of the user
     * @return boolean  true after adding the user in map
     */
    public boolean createAccount(String userId, String userName, User user);

    /** 
     * Delete the account
     * 
     * @param userId userId of the user
     */   
    public boolean deleteAccount(String userId);

    /**
     * Gets the loginCredentials 
     *
     * @return loginCredentials 
     */
    public Map<String, String> getLoginCredentials();

    /**
     * Gets the users
     *
     * @return users 
     */    
    public Map<String, User> getUsers();

    /**
     * Get the userNames 
     *
     * @return userNames
     */    
    public Set<String> getUserNames();    
    
}