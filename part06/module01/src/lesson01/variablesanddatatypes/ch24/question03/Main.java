package lesson01.variablesanddatatypes.ch24.question03;

public class Main {

    /**
     * Lesson 01 - Chapter 24
     * Problem Set -> Question 03
     */
    public static void main(String[] args) {
        /*
        Question 3
        Define an integer variable called bankBalance. Initialize it to a value of 500.
        Then add 250 to it. Then subtract 100 from it. Finally, print the resulting value.
         */
        int bankBalance = 500;
        bankBalance += 250;
        bankBalance -= 100;

        System.out.println(bankBalance); // 650
    }
}
