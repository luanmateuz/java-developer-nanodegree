package lesson02.controlflowandconditionals.ch26.question07;

public class Main {

    /**
     * Lesson 02 - Chapter 26
     * Problem Set -> Question 07
     */
    public static void main(String[] args) {
        /*
        Question 7
        Find the error in this Java code. (Hint: think about scope!)
        Imagine that the variables rewinding and playbackPosition could have different values
        depending on the situation.
         */
        double playbackPosition = 120;
        boolean rewinding = true;
        if (rewinding) {
            double rewindAmount = 0.1;
            playbackPosition = playbackPosition - rewindAmount;
        }

        System.out.println(playbackPosition);
    }
}
