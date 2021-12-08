package a.javabasicapi.string;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // String is a sequence of characters
        // String is immutable, you cannot change it once it's created
        // Constructors ex:
        //      String str = "abc";
        // is equivalent to:
        //      char data[] = {'a', 'b', 'c'};
        //      String str = new String(data);
        // Common methods

        String name = "Luan Mateus";
        int length = name.length(); // 11
        String toUpperCase = name.toUpperCase(); // LUAN MATEUS
        int compareTo = name.compareTo(toUpperCase); // 32
        int compareToIgnoreCase = name.compareToIgnoreCase(toUpperCase); // 0
        boolean equals = name.equals(toUpperCase); // false
        boolean equalsIgnoreCase = name.equalsIgnoreCase(toUpperCase); // true
        boolean contains = name.contains("Luan"); // true
        boolean empty = name.isEmpty(); // false
        String replace = name.replace("uan", "UAN"); // LUAN Mateus
        String[] split = name.split(" "); // split[0] = Luan; split[1] = Mateus;
        String trim = name.trim(); // Luan Mateus
    }
}
