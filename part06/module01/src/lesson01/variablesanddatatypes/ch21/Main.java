package lesson01.variablesanddatatypes.ch21;

public class Main {
    
    /**
     * Lesson 01 - Chapter 21
     * The 5th Subject
     */
    public static void main(String[] args) {
        /*
        Calculate the average
        Your friend seems to be really good at music,
        he managed to score 96% on his final exam!
        Now that you know all 5 subject grades,
        update the average calculation below to calculate the
        total average of all subjects.
        */

        double maths = 97.5;
        double english = 98;
        double science = 83.5;
        double drama = 75;
        double music = 96;
        double sum = maths + english + science + drama + music;
        double average = sum / 5;
        System.out.println(average);
    }
}
