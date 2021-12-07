package lesson04.loops.ch12;

public class Main {

    /**
     * Lesson 04 - Chapter 12
     * Count the blocks
     */
    public static void main(String[] args) {
        int blocks = countBlocks(3);
        System.out.println(blocks);
    }

    public static int countBlocks(int levels){
        int total = 0;
        for (int i = 1; i <= levels; i++) {
            total += (i * i);
        }
        return total;
    }
}
