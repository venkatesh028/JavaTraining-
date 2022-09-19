package com.ideas2it.util;

/**
 * Contain the validation part 
 *
 * @version 1.0 14-SEP-2022
 * @author Venkatesh TM
 */
public class ValidationUtil {
    
    /** 
     * Check the given data matches to the given format 
     * 
     * @param data     data need to be validated 
     * @param format   fixed format for the given data
     * @return boolean true if the given data matches the format else false
     */
    public boolean isValid(String data, String format) {
        return data.matches(format);
    }
}