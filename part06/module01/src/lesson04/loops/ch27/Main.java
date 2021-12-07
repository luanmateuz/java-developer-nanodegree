package lesson04.loops.ch27;

public class Main {

    /**
     * Lesson 04 - Chapter 27
     * Find the longest name
     */
    public static void main(String[] args) {
        String[] names = {"Nakita", "Elina", "Sheere", "Guy"};
        String search = search(names);
        System.out.println("Longest Name = " + search);
    }

    private static String search(String[] names) {
        String longestName = names[0];
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > longestName.length()) {
                longestName = names[i];
            }
        }

        return longestName;
    }
}
