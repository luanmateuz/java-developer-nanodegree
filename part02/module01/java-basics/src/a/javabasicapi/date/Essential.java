package a.javabasicapi.date;

import java.util.Date;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Java provides the Date class in java.util package,
        // this class encapsulates the current date and time
        // There are two Constructors for Date class:
        // Date() and Date(long millisec)
        // Common methods Java Date class

        // This class contains many methods DEPRECATED,
        // use alternatives like LocalDate, LocalTime, LocalDateTime

        Date date = new Date();
        long time = date.getTime(); // returns the number of milliseconds
        date.setTime(time); // set time in milliseconds
        boolean equals = date.equals(new Date(2020, 11, 11)); // false
                                    // **This Constructor is DEPRECATED
        int compareTo = date.compareTo(new Date(2021, 11, 6)); // -1
        boolean after = date.after(new Date(2021, 11, 6)); // false
        boolean before = date.before(new Date(2021, 11, 6)); // true
    }
}
