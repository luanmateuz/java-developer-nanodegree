package b.collections.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // List is an interface, and ArrayList and LinkedList are two common implementation for List.
        // The differences between ArrayList and LinkedList are ArrayList uses dynamic array
        // where LinkedList uses a doubly linked list to store elements.

        List<String> arrayList = new ArrayList<>();
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add(0, "A");

        System.out.println(arrayList);

        String get3 = arrayList.get(3);
        System.out.println(get3);

        arrayList.remove(4);
        System.out.println(arrayList);

        int size = arrayList.size();
        System.out.println(size);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("a");
        linkedList.add(1, "b");
        linkedList.add("d");
        linkedList.add("c");
        linkedList.addLast("e");

        System.out.println(linkedList);

        String first = linkedList.getFirst();
        System.out.println(first);

        ListIterator<String> listIterator = linkedList.listIterator();

        while (listIterator.hasNext()) {
            String next = listIterator.next();
            listIterator.set(next.toUpperCase());
        }

        System.out.println("linkedList UpperCase");
        for (String s: linkedList) {
            System.out.printf("%s ", s);
        }
    }
}
