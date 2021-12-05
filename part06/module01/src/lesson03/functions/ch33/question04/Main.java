package lesson03.functions.ch33.question04;

public class Main {

    /**
     * Lesson 03 - Chapter 33
     * Problem Set -> Question 04
     */
    public static void main(String[] args) {
        /*
        Question 4
        Write a Java function called absoluteValue(). The access modifier should be public, it
        should have a return type of double, and it should take one double parameter as input. If
        the double parameter is less than 0, it should return that number negated. Otherwise, it
        should return the parameter unchanged.
         */

        System.out.println(absoluteValue(-2.0));
    }

    public static double absoluteValue(double x) {
        return x < 0 ? -x : x;
    }
}
