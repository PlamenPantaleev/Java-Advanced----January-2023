package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) {

        String inputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\Files-and-Streams\\output.txt";


        try (BufferedReader input = new BufferedReader(new FileReader(inputPath));
             PrintStream writer = new PrintStream(new FileOutputStream(outputPath))) {
            int counter = 1;
            String line = input.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }

                line = input.readLine();
                counter ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
