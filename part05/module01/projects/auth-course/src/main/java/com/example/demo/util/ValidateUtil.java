package com.example.demo.util;

public class ValidateUtil {

    private ValidateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validatePassword(String passwd, String confirmPasswd) {
        return !passwd.isEmpty() && !confirmPasswd.isEmpty() && passwd.equals(confirmPasswd) && passwd.length() >= 8;
    }
}
