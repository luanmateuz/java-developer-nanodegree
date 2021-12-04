package lesson02.controlflowandconditionals.ch26.question05;

public class Main {

    /**
     * Lesson 02 - Chapter 26
     * Problem Set -> Question 05
     */
    public static void main(String[] args) {
        /*
        Question 5
        Assume you have access to a double variable called time. Write code that assigns a different
        value to the String variable timeOfDay based on the value of time in hours. If time is
        between 5 and 12, including 5 but not including 12, set timeOfDay to “morning”. If time is
        between 12 and 20, including 12 but not including 20, set timeOfDay to “daytime”. Finally,
        if the time variable does not satisfy either condition, set timeOfDay to “night”.
        Starting code:
         */

        int time = 18;
        String timeOfDay;
        if (time >= 5 && time < 12) {
            timeOfDay = "morning";
        } else if (time >= 12 && time < 20) {
            timeOfDay = "daytime";
        } else {
            timeOfDay = "night";
        }

        System.out.println(timeOfDay);
    }
}
