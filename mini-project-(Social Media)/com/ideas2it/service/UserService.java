package com.ideas2it.service;

import com.ideas2it.model.User;
import java.util.Map;
import java.util.HashMap;

/**
 *
 *
 * @author Venkatesh TM
 * @version 1.0
 */

public class UserService {
    Map<String,User> users = new HashMap<>();
    User user;
    
    public boolean createAccount(String key, User user) {
        if (null == users.putIfAbsent(key,user)) {
            return true;
        }
        return false;
    }
    
    public boolean deleteAccount(String email) {
        user = users.get(email);
        
        return users.remove(email,user);     
    }
    
    public boolean changeEmail(String email, String newEmail) {
        user = users.get(email);
        user.setEmail(newEmail);
        users.put(newEmail, user);
        return true;

    }
    
    public boolean changePassword(String email,String oldPassword,
                                      String newPassword) {
        return true;
    }

    public boolean changeName(String email, String newName) {
        user = users.get(email);
        user.setName(newName);
        return true;
    }
    
    public boolean isAccountExist(String email) {
        if (users.containsKey(email)) {
            return true;
        }
        return false;   
    }  
    
    public boolean isValidCredentials(String email, String password) {
        user = users.get(email);
 
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}