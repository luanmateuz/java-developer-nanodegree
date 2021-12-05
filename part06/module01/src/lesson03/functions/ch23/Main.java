package lesson03.functions.ch23;

public class Main {

    /**
     * Lesson 03 - Chapter 23
     * Rolling Dice
     */
    public static void main(String[] args) {
        int roll1 = rollDice();
        int roll2 = rollDice();

        System.out.println("Roll 1: " + roll1);
        System.out.println("Roll 2: " + roll2);
    }

    public static int rollDice() {
        // random num between 0 and (almost) 1
        double randomNumber = Math.random();

        // change range to 0 to (almost) 6
        randomNumber = randomNumber * 6;

        // shift range up one
        randomNumber = randomNumber + 1;

        // cast to integer (ignore decimal part)
        int randomInt = (int) randomNumber;

        // return statement
        return randomInt;
    }
}
