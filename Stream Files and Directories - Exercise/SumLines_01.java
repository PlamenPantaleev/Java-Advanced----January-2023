package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) {

        String path = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String current = input.readLine();
            while (current != null) {

                int bytes = 0;
                for (int i = 0; i < current.length(); i++) {
                    char symbol = current.charAt(i);
                    bytes += symbol;
                }
                    System.out.println(bytes);
                    bytes = 0;
                    current = input.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
