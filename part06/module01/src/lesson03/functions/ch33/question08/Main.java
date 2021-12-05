package lesson03.functions.ch33.question08;

public class Main {

    /**
     * Lesson 03 - Chapter 33
     * Problem Set -> Question 08
     */
    public static void main(String[] args) {
        /*
        Question 8
        Define a function called monopolyRoll(). This function provides a random result based on
        the dice-rolling rules for the board game Monopoly. In Monopoly, players roll two six-sided
        dice to determine their move. If they roll the same value on both dice, this is called “rolling
        doubles,” and it means they go again. In our simplified version, the dice-roll function should
        behave like this:
        1. Generate two random integers in the 1 to 6 range.
        2. If the numbers are not the same, return the sum.
        3. If the numbers are the same, generate two more random integers in the 1 to 6 range,
        and return the sum of all 4 numbers.
        Hint: to make your code neater, you can define a second function that generates a random
        integer in the 1 to 6 range (or in the 1 to x range based on a parameter) so that you do not
        need to keep repeating that code.
         */

    }

    /**
     * Returns a random integer simulating a dice roll.
     *
     * @param sides Number of sides on the virtual die being rolled.
     * @return random number in the range of 1 to sides.
     */
    public int diceRoll(int sides) {
        double randomNumber = Math.random() * sides;
        return (int) ++randomNumber;
    }

    public int monopolyRoll() {
        int roll1 = diceRoll(6);
        int roll2 = diceRoll(6);
        int total = roll1 + roll2;
        if (roll1 == roll2) {
            int roll3 = diceRoll(6);
            int roll4 = diceRoll(6);
            total = total + roll3 + roll4;
        }
        return total;
    }
}
