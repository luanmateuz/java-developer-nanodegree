package lesson01.variablesanddatatypes.ch20;

public class Main {

    /**
     * Lesson 01 - Chapter 20
     * Comments
     */
    public static void main(String[] args) {
        /*
        The following code estimates the number
        of students that will sign up for my course.
         */
        double current = 17;
        double rate = 1.5;
        double future = current * rate;
        System.out.println(future);
        // cast to integer
        int approx = (int) future;
        System.out.println(approx);
    }
}
