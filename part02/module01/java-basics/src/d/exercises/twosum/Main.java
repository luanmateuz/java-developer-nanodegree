package d.exercises.twosum;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        /*
        Task Description:
        Complete the “two sum” coding problem.

        Given an integer array, return true if two numbers in this array can be summed to target.

        Example1: input[1, 2, 3, 4], target:5, return true
        Example2: input[1, 4, 5, 1, 6], target 12, return false
         */
        boolean t1 = twoSum(new int[]{1, 2, 3, 4}, 5);
        boolean t2 = twoSum(new int[]{1, 4, 5, 1, 6}, 12);

        System.out.printf("t1 = %b%nt2 = %b%n", t1, t2);
    }

    public static boolean twoSum(int[] nums, int target) {
        Set<Integer> twoSumSet = new HashSet<>();
        for (int num : nums) {
            if (twoSumSet.contains(num)) {
                return true;
            }
            twoSumSet.add(target - num);
        }
        return false;
    }
}
