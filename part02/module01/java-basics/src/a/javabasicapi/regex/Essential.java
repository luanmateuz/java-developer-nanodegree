package a.javabasicapi.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Java provides two classes for Regex
        // Pattern and Matches, in the String class contains
        // some methods to use with Regex

        String string = "string string";
        string = string.replace("st", "ST");
        System.out.println(string);

        boolean matches = "Luan".matches("[A-Z][a-zA-Z]*"); // true

        Pattern expression = Pattern.compile("[A-Z]");
        Matcher matcher = expression.matcher(string);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
