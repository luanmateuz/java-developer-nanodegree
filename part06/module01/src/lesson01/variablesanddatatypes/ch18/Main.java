package lesson01.variablesanddatatypes.ch18;

public class Main {

    /**
     * Lesson 01 - Chapter 18
     * All the Maths
     */
    public static void main(String[] args) {
        // Variable Arithmetic
        // Addition, Subtraction, Multiplication, Division
        int x = 2 + 3; // 5
        int y = 4 - 5; // -1
        int temp = -20; // -20
        int days = 7 * 4; // 28
        double div = 5 / 2; // 2.(5) => 2
        double accurate = 5 / 2.0; // 2.5
        double div2 = 24 / 5; // 4.(8) => 4

        // Order
        // 1. Multiplication and Division * /
        // 2. Addition and Subtraction + -
        // if in doubt, use ()

        double paid = 10;
        double change = 3.25;
        double tip = (paid - change) * 0.2;
        System.out.println(tip); // 1.35
    }
}
