package c.exceptionandfileio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIO {

    /**
     * Lesson 01 - Java Refresher Course
     * Let's get up to speed with Java
     */
    public static void main(String[] args) {
        // Files (File)
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file or directory name:");

        Path path = Paths.get(input.nextLine());

        if (Files.exists(path)) {
            System.out.printf("%n%s exists%n", path.getFileName());
            System.out.printf("%s a directory%n%n", Files.isDirectory(path) ? "Is" : "Is not");

            System.out.println("Enter filename:");
            String fileName = input.nextLine();
            try {
                File myObj = new File(path + "/" + fileName + ".txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.printf("%s does not exist%n", path);
        }

        input.close();
    }
}
