package lesson02.controlflowandconditionals.ch21;

public class Main {

    /**
     * Lesson 02 - Chapter 21
     * Nested if Statements
     */
    public static void main(String[] args) {
        boolean action = true;
        boolean romance = true;
        boolean horror = false;
        boolean comedy = true;

        if (action && romance) {
            // includes action and romance
            System.out.println("This move includes action and romance.");
            if (comedy || horror) {
                // everyone's preferences have been met!
                System.out.println("This also includes comedy or horror!");
            }
        }
    }
}
