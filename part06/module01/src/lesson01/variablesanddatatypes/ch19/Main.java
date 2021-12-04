package lesson01.variablesanddatatypes.ch19;

public class Main {

    /**
     * Lesson 01 - Chapter 19
     * Casting
     */
    public static void main(String[] args) {
        // Truncation: cutting off the digits to the right of a decimal point
        double div = 5 / 2; // 2

        // Casting
        double current = 17;
        double rate = 1.5;
        double future = current * rate;
        System.out.println(future); // 25.5
        int approx = (int) future;
        System.out.println(approx); // 25

        int x = 5;
        int y = 2;
        double div2 = x / y;
        System.out.println(div2); // 2
        double accurate = (double) x / y;
        System.out.println(accurate); // 2.5
    }
}
