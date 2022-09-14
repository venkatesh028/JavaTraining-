package com.ideas2it.model;

/**
 * Contain the attributes of the User
 * Constructor is used to initialize the attributes 
 * and getter and setter method  is used to update and retrive the attributes
 * tostring method is used to return the values
 *
 * @version 1.0 08-SEP-2022
 * @author Venkatesh TM
 */
public class User {
    private String name; 
    private String email;
    private String password;
 
    public User() {
    }

    /**
     * Creates a new object for the User and initialize the feilds
     * of that class
     */   
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
   
    public void setName(String name) {
        this.name = name;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }
   
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString() {
        return "\n Name     : " + name
              +"\n Email    : " + email;            
    }
}