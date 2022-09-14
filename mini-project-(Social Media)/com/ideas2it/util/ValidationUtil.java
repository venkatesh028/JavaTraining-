package com.ideas2it.util;

public class ValidationUtil {

    public boolean isValid(String data, String format) {
        return data.matches(format);
    }
}