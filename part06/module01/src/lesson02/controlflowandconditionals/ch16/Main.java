package lesson02.controlflowandconditionals.ch16;

public class Main {

    /**
     * Lesson 02 - Chapter 15 and 16
     * Tickets to the Museum
     */
    public static void main(String[] args) {
        int ticketPrice = 10;
        int age = 15;
        boolean isStudent = true;

        if (age <= 15) {
            // age is less than or equal to 15
            ticketPrice = 5;
        } else if (age > 60) {
            // age is greater than 60
            ticketPrice = 5;
        } else if (isStudent) {
            // they are a student
            ticketPrice = 5;
        }

        System.out.println(ticketPrice);
    }
}
