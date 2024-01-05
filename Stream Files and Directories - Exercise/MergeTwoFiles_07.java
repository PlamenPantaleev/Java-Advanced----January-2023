package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {

        String inputPathOne = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPathTwo = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";


        PrintWriter writer = new PrintWriter("outputForExercise.txt");

        List<String> allFilesFromFileOne = Files.readAllLines(Path.of(inputPathOne));
        allFilesFromFileOne.forEach(writer::println);
        List<String> allFilesFromFileTwo = Files.readAllLines(Path.of(inputPathTwo));
        allFilesFromFileTwo.forEach(file -> writer.println(file));
        writer.close();
    }
}
