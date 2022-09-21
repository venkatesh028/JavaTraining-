package com.ideas2it.dao.daoImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ideas2it.dao.UserDao;
import com.ideas2it.model.User;

/**
 * Perform the creation and delete operation for the user account 
 * 
 * @version 1.0 19-SEP-2022
 * @author  Venkatesh TM
 */ 
public class UserDaoImpl implements UserDao {
    private static Map<String, User> users;
    private static Set<String> userNames;
    private static Map<String, String> loginCredentials;
    private User user;

    static {
        users = new HashMap<>();
        userNames = new HashSet<>();
        loginCredentials = new HashMap<>();
    }
    
    @Override
    public boolean createAccount(String userId, String userName, User user) {
        users.put(userId, user);
        loginCredentials.put(user.getEmail(), userId);
        userNames.add(userName);
        return true;        
    }
    
    @Override
    public boolean deleteAccount(String userId) {
        users.remove(userId);    
        return true;
    }
    
    @Override
    public Map<String, String> getLoginCredentials() {
        return loginCredentials; 
    }
    
    @Override
    public Map<String, User> getUsers() {
        return users;
    }    
    
    @Override
    public Set<String> getUserNames() {
        return userNames;
    }
    
}