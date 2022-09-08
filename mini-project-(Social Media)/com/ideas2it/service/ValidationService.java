package com.ideas2it.service;

public class ValidationService {
    
   private String emailFormat = "^[a-zA-Z0-9+_&-]+@[a-zA-Z0-9.]+$";
   private String passwordFormat = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"
                                     + "(?=.*[@#$%^&+=])" 
                                     + "(?=\\S+$).{8,20}$";

    public boolean isValid(String data, String format) {
        return data.matches(format);  
    }
   
    public boolean isValidEmail(String email) {        
        return isValid(email,emailFormat);         
    }
    
    public boolean isValidPassword(String password) {
        return isValid(password,passwordFormat);
    }
    
}