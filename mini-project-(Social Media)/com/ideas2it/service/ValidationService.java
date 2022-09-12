package com.ideas2it.service;

/**
 * Perform the validation to check the datat in the expected format
 * 
 * @version 1.0 08-SEP-2022
 * @author Venkaytesh TM
 */ 
public class ValidationService {
    
   private String emailFormat = "^[a-zA-Z0-9][a-zA-Z0-9.]{5,30}@[a-zA-Z0-9][a-zA-Z0-9.]{3,}$";
   private String passwordFormat = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"
                                     + "(?=.*[@#$%^&+=])" 
                                     + "(?=\\S+$).{8,20}$";
    
    /**
     * Check given data matches with the given format
     *
     * @param  data    email or password given by the user
     * @param  format  email or password format
     * @return boolean true if the data matches the format else false
     */ 
    public boolean isValid(String data, String format) {
        return data.matches(format);  
    }
    
    /**
     * Check given email is valid or not
     *
     * @param  email   entered email
     * @return boolean true if the format is correct or false
     */ 
    public boolean isValidEmail(String email) {        
        return isValid(email, emailFormat);         
    }

    /**
     * Check given password is valid or not
     *
     * @param  password   entered password
     * @return boolean true if the format is correct or false
     */     
    public boolean isValidPassword(String password) {
        return isValid(password, passwordFormat);
    }
    
}