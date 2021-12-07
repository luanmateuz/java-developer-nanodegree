package lesson04.loops.ch09;

public class Main {

    /**
     * Lesson 04 - Chapter 09
     * Warning Alert
     */
    public static void main(String[] args) {
        raiseAlarm(5);
    }

    public static void raiseAlarm(int numOfWarnings) {
        int i = 1;
        while (i <= numOfWarnings) {
            System.out.println("Warning");
            i++;
        }
    }
}
