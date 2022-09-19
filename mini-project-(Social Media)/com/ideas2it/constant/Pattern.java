package com.ideas2it.constant;

/**
 * Contain the Format of the email and password 
 *
 * @version 1.0 
 * @author Venkaetsh Tm
 */
public class Pattern {
    public final static String emailFormat = "^[a-zA-Z0-9][a-zA-Z0-9.]{3,30}@[a-zA-Z0-9]+\\.[a-zA-Z0-9.]{3,}$";
    public final static String passwordFormat = "^(?=.*[0-9])" 
                                                 + "(?=.*[a-z])(?=.*[A-Z])"
                                                 + "(?=.*[@#$%^&+=])" 
                                                 + "(?=\\S+$).{8,20}$";
}