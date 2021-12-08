package a.javabasicapi.math;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Need to import java.lang
        // All Math methods are static
        // Common methods

        double ceil = Math.ceil(9.1D); // 10.0
        double floor = Math.floor(9.99D); // 9.0
        double rint = Math.rint(5.59D); // 6.0
        long round = Math.round(5.76D); // 6
        double abs = Math.abs(-8.5D); // 8.5
        int max = Math.max(7, 9); // 9
        double pow = Math.pow(4.0, 2.0); // 4² => (4*4) = 16
        double sqrt = Math.sqrt(16); // 4.0
        double random = Math.random(); // random number entry 0 - 1
    }
}
