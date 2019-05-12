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
        if(value){
            throw new InvalidParameterException(message);
        }
    }
}
