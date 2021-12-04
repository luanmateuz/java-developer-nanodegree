package lesson02.controlflowandconditionals.ch10;

public class Main {

    /**
     * Lesson 02 - Chapter 10
     * else-if
     */
    public static void main(String[] args) {
        boolean isLightGreen = false; // true or false
        boolean isLightYellow = true; // true or false

        if (isLightGreen) {
            // traffic light is green
            System.out.println("Drive!");
        } else if (isLightYellow) {
            // light is NOT green but is yellow
            System.out.println("Slow down.");
        } else {
            // light is NOT green
            System.out.println("Stop.");
        }
    }
}
