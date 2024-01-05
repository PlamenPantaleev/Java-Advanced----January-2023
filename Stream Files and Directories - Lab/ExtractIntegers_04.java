package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\Files-and-Streams\\output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = new PrintStream(new FileOutputStream(outputPath));

        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }

            reader.next();
        }
    }
}
