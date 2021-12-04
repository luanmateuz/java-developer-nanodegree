package lesson01.variablesanddatatypes.ch14;

public class Main {

    /**
     * Lesson 01 - Chapter 14
     * String Operations
     */
    public static void main(String[] args) {
        String language = "java";
        String feeling = "Love";
        feeling = feeling.toLowerCase();
        language = language.toUpperCase();
        // I love JAVA
        System.out.println("I " + feeling + " " + language);
    }
}
