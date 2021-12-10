package d.exercises.firstduplicate;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        /*
        Task Description:
        Complete find the first duplicate character in a string.

        Complete the following method so given a string it returns the index of the first duplicated character or -1
        if there are no duplicated characters.

        Example1: input: abcabc, return: 3
        Example2: input: abcd, return: -1
         */

        int t1 = findDuplicate("abcabc");
        int t2 = findDuplicate("abcd");

        System.out.printf("t1 = %d%nt2 = %d%n", t1, t2);
    }

    public static int findDuplicate(String input) {
        HashSet<Character> stringHashSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (stringHashSet.contains(input.charAt(i))) {
                return i;
            } else {
                stringHashSet.add(input.charAt(i));
            }
        }

        return -1;
    }
}
