package lesson02.controlflowandconditionals.ch17;

public class Main {

    /**
     * Lesson 02 - Chapter 17 and 18
     * Logical Operators
     */
    public static void main(String[] args) {
        // Logical Operator
        // && (AND)  || (OR)  ! (NOT)

        boolean test1 = 3 < 5 && 2 > 15; // false
        boolean test2 = 3 < 5 || 2 > 15; // true
        boolean test3 = !(3 < 5); // false

        /*
        Just like how math operators (*, /, +, -) have an order that they are evaluated in, ie.
        multiplication is evaluated before addition, so do logical operators! The ! operator will be evaluated first,
        then &&, and finally ||. If you have a bunch of the same operations in an expression, like multiple ||
        combinations, then you just operate from left to right.
        To change the order of operations you can surround expressions in parentheses because parentheses will be
        evaluated before anything else.
        So, the order of operations is:

        0. Parentheses
        1. NOT !
        2. AND &&
        3. OR ||

         */
    }
}
