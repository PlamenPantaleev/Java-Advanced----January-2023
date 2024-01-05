package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.*;

public class AllCapitals_03 {
    public static void main(String[] args) {

        String inputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";



        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter outputWriter = new PrintWriter(new FileWriter(outputPath))) {

            String currentLine = inputReader.readLine();
            while (currentLine != null) {
                outputWriter.println(currentLine.toUpperCase());
                currentLine = inputReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
