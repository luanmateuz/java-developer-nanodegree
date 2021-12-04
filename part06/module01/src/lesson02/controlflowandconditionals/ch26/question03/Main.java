package lesson02.controlflowandconditionals.ch26.question03;

public class Main {

    /**
     * Lesson 02 - Chapter 26
     * Problem Set -> Question 03
     */
    public static void main(String[] args) {
        /*
        Question 3
        You are programming the behavior of an enemy in a video game. The enemy code has access
        to two boolean variables, canSeePlayer and playerPoweredUp. canSeePlayer is true
        when the enemy can see the player and false otherwise, and playerPoweredUp is true when
        the player has found a special item that makes them impossible to defeat temporarily. Fill
        in the correct conditions so that “Attack!” is printed when the enemy can see the player
        and the player is not powered-up, “Run away!” is printed when the player is visible and is
        powered-up, and finally, “Wander.” is printed if the player is not visible.
        Starting code:
         */
        boolean canSeePlayer = true;
        boolean playerPoweredUp = false;

        if (canSeePlayer) {
            if (!playerPoweredUp) {
                System.out.println("Attack!");
            } else {
                System.out.println("Run away!");
            }
        } else {
            System.out.println("Wander.");
        }
    }
}
