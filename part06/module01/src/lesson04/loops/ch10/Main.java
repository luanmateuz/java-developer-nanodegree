package lesson04.loops.ch10;

public class Main {

    /**
     * Lesson 04 - Chapter 10
     * For Loop
     */
    public static void main(String[] args) {
        raiseAlarm(5);
    }

    public static void raiseAlarm(int numOfWarnings) {
        for (int i = 1; i <= numOfWarnings; i++) {
            System.out.println("Warning");
        }
    }
}
