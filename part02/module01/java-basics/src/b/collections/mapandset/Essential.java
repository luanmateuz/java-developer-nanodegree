package b.collections.mapandset;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Essential {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Map is Key Value
        // Hash(Map or Set): no order (map or set)
        // Tree(Map or Set): ordered (map or set)

        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("Name", "John");
        stringMap.put("Phone", "9999");

        stringMap.forEach((k, v) -> System.out.printf("%-10s %s%n", k, v));

        System.out.println("------------------");
        stringMap.remove("Phone");
        stringMap.forEach((k, v) -> System.out.printf("%-10s %s%n", k, v));

        System.out.println("------------------");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("LoL");
        stringSet.add("Minecraft");
        stringSet.add("CS:GO");

        System.out.println(stringSet);

        stringSet.remove("LoL");
        System.out.println(stringSet);
    }
}
