package com.ideas2it.controller;

import com.ideas2it.service.UserService;
import com.ideas2it.service.ValidationService;
import com.ideas2it.model.User;

public class UserController {
    UserService userService = new UserService();
    ValidationService validationService = new ValidationService();
    
    public boolean createAccount(String key,User user){
        return userService.createAccount(key,user);
    }

    public boolean isAccountExist(String email) {
        return userService.isAccountExist(email);       
    }
    
    public boolean isValidCredentials(String email,String password) {
        return userService.isValidCredentials(email,password);
    }
    
    public boolean isValidEmail(String email) {
        return validationService.isValidEmail(email);
    }
   
    public boolean isValidPassword(String password) {
        return validationService.isValidPassword(password);
    }
    
    public boolean deleteAccount(String email) {
        return userService.deleteAccount(email);
    }
    
    public boolean addComment() {
        return true;
    }
    
    public boolean addLike() {
        return true;
    }
}