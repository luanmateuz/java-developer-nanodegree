package lesson04.loops.ch36.question06;

public class Main {

    /**
     * Lesson 04 - Chapter 36
     * Problem Set -> Question 06
     */
    public static void main(String[] args) {
        /*
        Question 6
        Complete the function below, which finds the range covered by an integer array. Inside
        the function, find the smallest value in the parameter array, and find the largest value, and
        return the largest value minus the smallest value. If the array has length 0, return -1.
        For example, if the variable myIntArray had the value
        {1, 0, 2, 3, -1, 2}
        then the function call
        findRange(myIntArray)
        would return 4. The largest value in the array is 3, the smallest value is -1, and 3−(−1) = 4.
        Starting code:
        public int findRange(int[] intArray) {
        return -1;
        }
         */
        int[] myIntArray = {1, 0, 2, 3, -1, 2};
        int range = findRange(myIntArray);
        System.out.println(range);
    }

    public static int findRange(int[] intArray) {
        if (intArray.length == 0) {
            return -1;
        }
        int small = intArray[0];
        int large = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] < small) {
                small = intArray[i];
            }
            if (intArray[i] > large) {
                large = intArray[i];
            }
        }
        return large - small;
    }
}
