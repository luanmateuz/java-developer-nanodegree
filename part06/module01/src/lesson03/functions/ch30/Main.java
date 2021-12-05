package lesson03.functions.ch30;

public class Main {

    /**
     * Lesson 03 - Chapter 30 and 31
     * Java Documentation Comments
     */
    public static void main(String[] args) {
        int number = absValue(-3);
        System.out.println(number);
    }

    /**Returns the absolute value of an int value. If the argument is not negative, the argument
     * is returned. If the argument is negative, the negation of the argument is returned.
     *
     * @param number the argument whose absolute value is to be determined
     * @return the absolute value of the argument.
     */
    public static int absValue(int number) {
        return Math.abs(number);
    }
}
