package lesson03.functions.ch33.question07;

public class Main {

    /**
     * Lesson 03 - Chapter 33
     * Problem Set -> Question 07
     */
    public static void main(String[] args) {
        /*
        Question 7
        Define two functions. The first should be called fahrenheitToCelsius(). It should be
        a public function with return type double that takes a double argument that represents a
        temperature in Fahrenheit degrees. It should return the equivalent temperature in Celsius
        degrees. (To convert from Fahrenheit to Celsius, use the formula C= (F−32) ×5/9.)
        Next, define a function called printTemperature(). It should be public, it should have a
        return type of void, and it should take a double parameter that represents a temperature in
        Fahrenheit degrees. This function should print “F: ” followed by the Fahrenheit parameter,
        then “C: ” followed by the equivalent value in Celsius degrees. Use the first function you
        defined to calculate the appropriate Celsius value inside the second function.
        Bonus challenge: write javadoc comments for both functions.
         */

    }

    /**
     * Converts from Fahrenheit to Celsius degrees.
     * @param fahrenheit Temperature in degrees Fahrenheit.
     * @return Equivalent temperature in degrees Celsius.
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    /**
     * Prints a temperature in both Fahrenheit and Celsius degrees.
     * @param fahrenheit Temperature in degrees Fahrenheit.
     */
    public void printTemperature(double fahrenheit) {
        System.out.println("F: " + fahrenheit);
        System.out.println("C: " + fahrenheitToCelsius(fahrenheit));
    }
}
