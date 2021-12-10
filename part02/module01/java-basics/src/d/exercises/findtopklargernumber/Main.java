package d.exercises.findtopklargernumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        /*
        Complete the “find top k larger number” in an unsorted integer array.

        Given an unsorted integer array, return the top k larger number in a sorted list.
        The k is always less than array size. Make sure the time complexity is less than O(nlogn).

        Example 1: [-1, 15, 59, 22, 6, 42, 45, 0], k=4, return {22, 42, 45, 59}
        Example 2: [5, 10, 22, 100, 8], k=2, return {22, 100}
         */
        List t1 = findTopKLargerNumber(new int[]{-1, 15, 59, 22, 6, 42, 45, 0}, 4);
        List t2 = findTopKLargerNumber(new int[]{5, 10, 22, 100, 8}, 2);

        System.out.printf("t1 = %s%nt2 = %s%n", t1, t2);
    }

    public static List<Integer> findTopKLargerNumber(int[] array, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int a: array) {
            treeSet.add(a);
            if (treeSet.size() > k) {
                treeSet.pollFirst();
            }
        }

        return new ArrayList<>(treeSet);
    }
}
