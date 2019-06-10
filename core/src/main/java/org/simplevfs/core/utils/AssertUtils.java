package org.simplevfs.core.utils;

import org.simplevfs.core.exception.InvalidParameterException;

public class AssertUtils {

    public static void verifyNotNull(Object o,String message){
        if(o==null){
            throw new NullPointerException(message);
        }
    }

    public static void verifyNotEmpty(String s,String message){
        if(s==null||s.trim().isEmpty()){
            throw new InvalidParameterException(message);
        }
    }

    public static void verifyTrue(boolean value,String message){
        if(!value){
            throw new InvalidParameterException(message);
        }
    }

    public static void verifyValideName(String s){
        if(s==null||s.trim().isEmpty()){
            throw new InvalidParameterException("Path Name must not be empty");
        }
        char firstChar=s.charAt(0);
        if(!Character.isLetter(firstChar)){
            throw new InvalidParameterException("Path Name must star with letter");
        }
        for(char c:s.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                throw new InvalidParameterException("Path Name must contain only letter or digit");
            }
        }
    }
}
