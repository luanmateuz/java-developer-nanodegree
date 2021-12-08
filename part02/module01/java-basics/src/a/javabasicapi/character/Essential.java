package a.javabasicapi.character;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Create a Character object: Character ch = new Character('a');
        // or Character ch = 'a'; or Character ch = Character.valueOf('a');
        // Common methods

        Character ch = Character.valueOf('a');
        boolean letter = Character.isLetter('a'); // true
        boolean digit = Character.isDigit('a'); // false
        boolean whitespace = Character.isWhitespace(ch); // false
        boolean upperCase = Character.isUpperCase(ch); // false
        char toUpperCase = Character.toUpperCase(ch); // A
        char toLowerCase = Character.toLowerCase(ch); // a
        String toString = Character.toString(ch); // a
    }
}
