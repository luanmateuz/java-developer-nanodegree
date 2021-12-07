package lesson04.loops.ch36.question04;

public class Main {

    /**
     * Lesson 04 - Chapter 36
     * Problem Set -> Question 04
     */
    public static void main(String[] args) {
        /*
        Question 4
        A savings account yields 5% interest annually. This Java function is designed to determine
        how many years it will take for you to have $1,000,000 on deposit given an initial value. The
        parameter represents the initial deposit, and the function should return an integer number
        of years before there will be $1,000,000 or more in the account. Write a loop to determine
        the number of years, and return that value.
        (Hint: Do we know how many times this loop needs to iterate? Does this mean a for loop
        or a while loop is more appropriate?)
        Starting code:
        public int yearsTilOneMillion(double initialBalance) {
        return 0;
        }
         */
        int yearsTilOneMillion = yearsTilOneMillion(100000);
        System.out.println(yearsTilOneMillion);
    }

    public static int yearsTilOneMillion(double initialBalance) {
        int years = 0;
        double balance = initialBalance;
        while (balance < 1000000) {
            years++;
            balance = balance * 1.05;
        }

        return years;
    }
}
