package com.ideas2it.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.ideas2it.model.User;
import com.ideas2it.dao.UserDao;
import com.ideas2it.dao.daoImpl.UserDaoImpl;
import com.ideas2it.util.ValidationUtil;


/**
 * Perform the create, delete ,change and validation
 * Based on the user request 
 *
 * @author Venkatesh TM
 * @version 1.0 08-SEP-2022
 */
public class UserService {
    private static Map<String, User> users;
    private static Set<String> userNames;
    private static Map<String, String> loginCredentials;
    private String userId;
    private ValidationUtil validationUtil;
    private User user;
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDaoImpl();
        this.validationUtil = new ValidationUtil();
    }

    /**
     * Create account for the user and add with id as key in users
     *  
     * @param  userName userName of the user
     * @param  user     details of the user
     * @return boolean  true after adding the user in map
     */
    public boolean createAccount(String userName, User user) {
        userId = UUID.randomUUID().toString();
        userDao.createAccount(userId, userName, user);          
        return true;
    }
    
    /**
     * check the email is already exist or not 
     * 
     * @param  email   email entered by the user
     * @return boolean true or false based on the result
     */
    public boolean isAccountExist(String email) {
        loginCredentials = userDao.getLoginCredentials();
        return loginCredentials.containsKey(email);
    }
    
    /**
     * Check the given credentials are valid
     *
     * @param  email    email of the user
     * @param  password password entered by the user
     * @return boolean  true or false based on the result
     */
    public boolean isValidCredentials(String email, String password) {
        loginCredentials = userDao.getLoginCredentials();
        users = userDao.getUsers();
        user = users.get(loginCredentials.get(email));

        if (user.getEmail().equals(email) &&
            user.getPassword().equals(password)) {
                return true;
        }
        return false;
    }
   
    /**
     * Is given email is valid or not
     *
     * @param email    email enterd by the user
     * @return boolean true or false based on the result
     */  
    public boolean isValidEmail(String email) {
        return validationUtil.isValidEmail(email);
    }
    
    /**
     * Is given password is valid or not
     *
     * @param  password password entered by the user
     * @return boolean  true or false based on the result 
     */
    public boolean isValidPassword(String password) {
        return validationUtil.isValidPassword(password);
    }
    
    /**
     * Check the given userName is already exist or not 
     *
     * @param  userName username entered by the user
     * @return boolean based on the result
     */ 
    public boolean isUsernameExist(String userName) { 
        userNames = userDao.getUserNames();
        return userNames.contains(userName);
    }
    
    /**
     * Check the given email is already exist or not
     * 
     * @param  email   email entered by the user
     * @return boolean true or false based on the result
     */
    public boolean isEmailExist(String email) {
        loginCredentials = userDao.getLoginCredentials();
        return loginCredentials.containsKey(email);
    }
    
    /**
     * Get userId for the given email 
     * 
     * @param  email   email entered by the user
     * @return boolean true or false based on the result
     */
    public String getUserId(String email) {
        loginCredentials = userDao.getLoginCredentials();
        return loginCredentials.get(email);
    }
    
}
