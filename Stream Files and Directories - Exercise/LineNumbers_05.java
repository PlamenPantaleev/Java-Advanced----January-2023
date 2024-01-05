package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        String inputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        //List<String> text = Files.readAllLines(Path.of(inputPath));
        int counter = 0;



        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter outputPrint = new PrintWriter(new FileWriter(outputPath))) {

            String currentLine = inputReader.readLine();

            while (currentLine != null) {

                counter++;
                outputPrint.printf("%d. %s%n", counter, currentLine);
                currentLine = inputReader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        //for (String line: text) {
        // String currentLine = line;
        //counter++;
        //outputPrint.println(counter + ". " + currentLine);
        //System.out.println(counter  + ". " + currentLine);
    }
}
