package lesson02.controlflowandconditionals.ch26.question01;

public class Main {

    /**
     * Lesson 02 - Chapter 26
     * Problem Set -> Question 01
     */
    public static void main(String[] args) {
        /*
        Question 1
        What will the following block of Java code print?
         */
        double balance = 0;
        balance = balance + 20; //Add quarter 1 profits (thousands).
        balance = balance - 25; //Subtract quarter 1 expenses (thousands).
        balance = balance + 30; //Add quarter 2 profits (thousands).
        balance = balance - 25; //Subtract quarter 1 expenses (thousands).
        if (balance < 0) {
            System.out.println("We’re in the red!");
        } else if (balance > 0) {
            System.out.println("We made a profit!");
        } else {
            System.out.println("We broke even.");
        }
        /*
        A. We’re in the red!
        B. We made a profit!
        C. We broke even.

        Letter 'C'
        */
    }
}
