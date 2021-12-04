package lesson02.controlflowandconditionals.ch07;

public class Main {

    /**
     * Lesson 02 - Chapter 07
     * Variable Scope
     */
    public static void main(String[] args) {
        boolean isLightGreen = true; // true or false

        if (isLightGreen) {
            // traffic light is green
            double carSpeed = 100.0D; // in km/hr
            System.out.println("Drive!");
            System.out.println("Speed is: " + carSpeed);
        }
        // carSpeed = carSpeed - 10; // outside scope ERROR!
    }
}
