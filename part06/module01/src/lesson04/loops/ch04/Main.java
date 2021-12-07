package lesson04.loops.ch04;

public class Main {

    /**
     * Lesson 04 - Chapter 04
     * Googol
     */
    public static void main(String[] args) {
        String googol = "1";
        int length = googol.length();
        while (length < 101) {
            googol += "0";
            length += googol.length();
        }
        System.out.println(googol);
    }
}
