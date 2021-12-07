package lesson04.loops.ch03;

public class Main {

    /**
     * Lesson 04 - Chapter 03
     * While Loops
     */
    public static void main(String[] args) {
        boolean isRaining = true;

        while(isRaining){
            System.out.println("It's still raining outside!");
            isRaining = checkWeather();
        }
        System.out.println("Now it's not raining anymore");
    }

    private static boolean checkWeather() {
        return false;
    }
}
