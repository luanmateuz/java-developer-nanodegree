package a.javabasicapi.stringbuilderandbuffer;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // StringBuilder and StringBuffer contains the same methods, but
        // only StringBuffer is thread safe
        // Commons methods
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder("this is stringBuilder");
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer("this is stringBuffer");

        System.out.printf("buffer %s%nlength = %d%ncapacity = %d%n%n",
                buffer, buffer.length(), buffer.capacity());

        buffer.ensureCapacity(32);
        System.out.printf("buffer capacity = %d%n%n", buffer.capacity());

        buffer2.setLength(4);
        System.out.printf("%s%n%n", buffer2.toString());

        // StringBuilder and StringBuffer is mutable
        System.out.printf("%s%n", buffer2.charAt(0));
        buffer2.setCharAt(0, 'T');
        System.out.printf("%s%n", buffer2);
        System.out.printf("%s%n", builder2);
        builder2.append("!");
        System.out.printf("builder2 = %s%n", builder2);
        builder2.reverse();
        System.out.printf("%s%n", builder2);
        builder2.insert(0, "Insert | ");
        System.out.printf("%s%n", builder2);
        builder2.delete(0, 2);
        System.out.printf("%s%n", builder2);
    }
}
