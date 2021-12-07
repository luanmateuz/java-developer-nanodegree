package lesson04.loops.ch36.question02;

public class Main {

    /**
     * Lesson 04 - Chapter 36
     * Problem Set -> Question 02
     */
    public static void main(String[] args) {
        /*
        Question 2
        Complete the factorial() function below. It should return the product of all the numbers
        from 1 to the parameter n. For example, factorial(5) should return 120 because 1 x 2 x
        3 x 4 x 5 = 120. Think about what kind of loop you want to use to accomplish this.
        Starting code:
        public int factorial(int n) {
        }
         */
        int factorial = factorial(5);
        System.out.println(factorial);
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
