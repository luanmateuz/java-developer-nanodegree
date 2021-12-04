package lesson01.variablesanddatatypes.ch24.question07;

public class Main {

    /**
     * Lesson 01 - Chapter 24
     * Problem Set -> Question 07
     */
    public static void main(String[] args) {
        /*
        Question 7
        Write Java code to define a double variable called fahrenheit and set it to an initial value
        between 0 and 100. Then, create a double variable called celsius, and calculate its value
        based on the value of fahrenheit. (To convert from Fahrenheit to Celsius, subtract 32,
        then multiply by 5, then divide by 9.) Finally, print the final value of celsius.
         */
        double fahrenheit = 68.0D;
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Celsius: " + celsius + "°C");
    }
}
