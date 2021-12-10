package c.exceptionandfileio;

public class JavaExceptionExample {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String args[]){
        try{
            //code that may raise exception
            int data = 100 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        //rest code of the program
        System.out.println("rest of the code...");
    }
}
