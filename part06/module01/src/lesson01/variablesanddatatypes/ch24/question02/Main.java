package lesson01.variablesanddatatypes.ch24.question02;

public class Main {

    /**
     * Lesson 01 - Chapter 24
     * Problem Set -> Question 02
     */
    public static void main(String[] args) {
        /*
        Question 2
        What value for register will be printed at the end of this block of Java code?
        */
        double register = 10.0;
        register = register + 5; //Customer pays $5.
        register = register - 2.5; //Customer receives $2.50 as change.
        register = register + 10; //Customer pays $10.
        register = register - 3; //Customer receives $3 as change.
        System.out.println(register);
        /*
        A. 19.0
        B. 19.5
        C. 22.5
        D. 25.5

        Letter 'B'
         */
    }
}
