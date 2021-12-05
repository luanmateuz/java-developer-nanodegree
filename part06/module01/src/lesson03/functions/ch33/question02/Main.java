package lesson03.functions.ch33.question02;

public class Main {

    /**
     * Lesson 03 - Chapter 33
     * Problem Set -> Question 02
     */
    public static void main(String[] args) {
        /*
        Question 2
        Write the signature of a function called isPrime(). The access modifier should be public,
        the return type should be boolean, and it should take a single integer parameter.
         */

        System.out.println(isPrime(13));
    }

    public static boolean isPrime(int n) {
        int q = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                q++;
            }

            if (q > 2) {
                return false;
            }
        }
        return true;
    }
}
