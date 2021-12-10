package b.collections.stackandqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Stack -> LIFO (last-in-first-out)
        // Queue -> FIFO (first-in-first-out)

        Stack<String> stringStack = new Stack<>();
        stringStack.add("Lisa");
        stringStack.add("Ariel");
        stringStack.add("Daniel");

        System.out.println(stringStack);
        String pop = stringStack.pop();
        System.out.printf("%-30s pop = %s%n", stringStack, pop);
        stringStack.push("John");
        System.out.println(stringStack);
        String peek = stringStack.peek();
        System.out.printf("%-30s peek = %s%n", stringStack, peek);

        Queue<String> stringQueue = new PriorityQueue<>(Arrays.asList("J", "K", "L"));
        stringQueue.add("I");

        System.out.println(stringQueue);

        String poll = stringQueue.poll();
        System.out.printf("%-30s poll = %s%n", stringQueue, poll);

        String element = stringQueue.element();
        System.out.printf("%-30s element = %s%n", stringQueue, element);

    }
}
