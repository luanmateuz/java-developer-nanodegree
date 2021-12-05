package lesson03.functions.ch08;

public class Main {

    /**
     * Lesson 03 - Chapter 08
     * Play Music
     */
    public static void main(String[] args) {
        // Define a function playMusic() below.
        // This should print out: "Music is playing" when playButton is true
        // and "Music is paused" when playButton is false.

        playMusic();
    }

    public static void playMusic() {
        boolean playButton = true;

        if (playButton) {
            System.out.println("Music is playing");
        } else {
            System.out.println("Music is paused");
        }
    }
}
