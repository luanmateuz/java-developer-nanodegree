package lesson01.variablesanddatatypes.ch24.question06;

public class Main {

    /**
     * Lesson 01 - Chapter 24
     * Problem Set -> Question 06
     */
    public static void main(String[] args) {
        /*
        Question 6
        Write Java code to create a String variable called firstName, define it to be your first name
        as a String. Then define a variable called lastName and define it to be your last name as a
        String. Then define a variable called fullName and set it to be your first name followed by
        a space followed by your last name. Use the existing variables for your first and last name
        and String concatenation to define fullName. Finally, write code to print this text:
        Hello, my name is [full name].
        There are [number] letters in my name.
        Use String concatenation to create the first String to print using the fullName variable, and
        use the .length() command on firstName and lastName to calculate the number of letters.
        Note: you can concatenate an integer and a String and the integer will be converted to a
        String. For example, this expression:
        "There are "+ 7 + "days in a week."
        will be evaluated as the String:
        "There are 7 days in a week."
         */
        String firstName = "Luan";
        String lastName = "Mateuz";
        String fullName = firstName + " " + lastName;
        int letters = firstName.length() + lastName.length();

        System.out.println("Hello, my name is " + fullName + ".");
        System.out.println("There are " + letters + " letters in my name.");
    }
}
