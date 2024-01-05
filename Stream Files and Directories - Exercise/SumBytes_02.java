package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) {

        String path = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            int bytes = 0;
            String current = input.readLine();
            while (current != null) {

                for (int i = 0; i < current.length(); i++) {
                    char symbol = current.charAt(i);
                    bytes += symbol;
                }
                current = input.readLine();
            }
            System.out.println(bytes);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
