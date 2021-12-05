package lesson03.functions.ch21;

public class Main {

    /**
     * Lesson 03 - Chapter 21
     * Making Change
     */
    public static void main(String[] args) {
        // Define a function with the name and parameters: makeChange(double itemCost, double dollarsProvided)
        // Calculate and return the calculated change which should be the dollarsProvided minus the itemCost

        // Remember to return a value you need 1) a return type and 2) a return statement
        double returnedChange = makeChange(3.60, 5.75);

        System.out.println(returnedChange);
    }

    public static double makeChange(double itemCost, double dollarsProvided) {
        double change = dollarsProvided - itemCost;
        return change;
    }
}
