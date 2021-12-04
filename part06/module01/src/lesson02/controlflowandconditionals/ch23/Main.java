package lesson02.controlflowandconditionals.ch23;

public class Main {

    /**
     * Lesson 02 - Chapter 23
     * Switch Statement
     */
    public static void main(String[] args) {
        int passcode = 555;
        String coffeType;

        switch (passcode) {
            case 555:
                coffeType = "Espresso";
                break;
            case 312:
                coffeType = "Vanilla latte";
                break;
            case 629:
                coffeType = "Drip coffee";
                break;
            default:
                coffeType = "Unknown";
                break;
        }
        System.out.println(coffeType);
    }
}
