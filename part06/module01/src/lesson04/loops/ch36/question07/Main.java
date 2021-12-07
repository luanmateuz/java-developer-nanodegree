package lesson04.loops.ch36.question07;

public class Main {

    /**
     * Lesson 04 - Chapter 36
     * Problem Set -> Question 07
     */
    public static void main(String[] args) {
        /*
        Question 7
        What will be printed by this block of Java code?
        #
        ##
        ###
         */
        int rows = 3;
        for (int i = 1; i <= rows; i++) {
            String thisRow = "";
            for (int j = 0; j < i; j++) {
                thisRow = thisRow + "#";
            }
            System.out.println(thisRow);
        }
    }
}
