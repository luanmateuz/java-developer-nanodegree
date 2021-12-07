package lesson04.loops.ch26;

public class Main {

    /**
     * Lesson 04 - Chapter 26
     * Rubik's Cube Championship
     */
    public static void main(String[] args) {
        double[] speeds = new double[]{7.85, 7.32, 4.9, 6.22, 5.4, 7.3, 5.19};
        double search = search(speeds);
        System.out.println("MIN = " + search);
    }

    private static double search(double[] speeds) {
        int size = speeds.length;
        double min = speeds[0];
        for (int i = 1; i < size; i++) {
            if (speeds[i] < min) {
                min = speeds[i];
            }
        }

        return min;
    }
}
