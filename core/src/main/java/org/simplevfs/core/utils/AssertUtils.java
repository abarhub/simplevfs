package org.simplevfs.core.utils;

public class AssertUtils {

    public static void verifyNotNull(Object o,String message){
        if(o==null){
            throw new NullPointerException(message);
        }
    }

    public static void verifyNotEmpty(String s,String message){
        if(s==null||s.trim().isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static void verifyTrue(boolean value,String message){
        if(value){
            throw new IllegalArgumentException(message);
        }
    }
}
