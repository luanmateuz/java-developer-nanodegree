package lesson01.variablesanddatatypes.ch12;

public class Main {

    /**
     * Lesson 01 - Chapter 12
     * Variables (Strings)
     */
    public static void main(String[] args) {
        String driver;
        driver = "Hamish";

        int letters = driver.length();
        System.out.println(letters);

        driver = driver.toUpperCase();
        System.out.println(driver);
    }
}
