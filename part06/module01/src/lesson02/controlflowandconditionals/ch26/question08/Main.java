package lesson02.controlflowandconditionals.ch26.question08;

public class Main {

    /**
     * Lesson 02 - Chapter 26
     * Problem Set -> Question 08
     */
    public static void main(String[] args) {
        /*
        Question 8
        Assume the int variable dayOfWeek has some value, and that it follows this rule:
        1 = Monday
        2 = Tuesday
        3 = Wednesday
        4 = Thursday
        5 = Friday
        6 = Saturday
        7 = Sunday
        Declare a String variable called schedule and write a switch statement that gives schedule
        a different value based on the day of the week. For Monday, give it the value “Gym in the
        morning.” For Tuesday give it the value “Class after work.” For Wednesday, give it the value
        “Meetings all day.” For Thursday give it the value “Work from home.” For Friday, give it
        the value “Game night after work.” For Saturday and Sunday, give it the value “Free!” This
        should also be the default value.
        OR (optional): decide what to assign schedule for each day based on your own weekly
        schedule!
         */
        int dayOfWeek = 1;
        String schedule;
        switch (dayOfWeek) {
            case 1:
                schedule = "Gym in the morning.";
                break;
            case 2:
                schedule = "Class after work.";
                break;
            case 3:
                schedule = "Meetings all day.";
                break;
            case 4:
                schedule = "Work from home.";
                break;
            case 5:
                schedule = "Game night after work.";
                break;
            case 6:
            case 7:
            default:
                schedule = "Free!";
                break;
        }
        System.out.println(schedule);
    }
}
