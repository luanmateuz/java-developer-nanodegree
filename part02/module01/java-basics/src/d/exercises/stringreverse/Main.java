package d.exercises.stringreverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
        Task Description:
        Complete the “String reverse” coding problem.

        Write a function that takes a string as input and returns the string reversed.

        Example1: input: "Hello World!", return "!dlroW olleH"
        Example2: input: “abcde”, return “edcba”
         */

        String t1 = reverseString("Hello World!");
        String t2 = reverseString("abcde");

        System.out.printf("t1 = %s%nt2 = %s%n", t1, t2);
    }

    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
