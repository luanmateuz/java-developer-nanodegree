package lesson04.loops.ch36.question03;

public class Main {

    /**
     * Lesson 04 - Chapter 36
     * Problem Set -> Question 03
     */
    public static void main(String[] args) {
        /*
        Question 3
        Complete the code in this function to find and return the lowest index in the String array stringArray that the String target occurs. If the String target does not occur in
        stringArray, -1 should be returned.
        Starting code:
        public int indexOfFirstOccurrence(String[] stringArray, String target)
        {
        return -1;
        }
        As an example of how this function should work, this code should print 1, because the word
        “Java” appears at index 1.
        String[] sentence = {"Learning", "Java", "is", "fun."};
        int indexOfWordJava = indexOfFirstOccurrence(sentence, "Java");
        System.out.println(indexOfWordJava);
        Hint: you cannot compare two Strings using the == operator! This will be false unless
        the two Strings are actually the same String object, not just two Strings with the same
        letters. To check whether two Strings have the same letters, use the equals() method:
        if (myString1.equals(myString2)).
         */
        String[] sentence = {"Learning", "Java", "is", "fun."};
        int indexOfWordJava = indexOfFirstOccurrence(sentence, "Java");
        System.out.println(indexOfWordJava);
    }

    public static int indexOfFirstOccurrence(String[] stringArray, String target) {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
