package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WriteToAFile_02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\Files-and-Streams\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\Files-and-Streams\\output.txt";

        List<Character> punctuation = Arrays.asList(',', '.', '!','?');

        OutputStream output = new FileOutputStream(outputPath);
        try (InputStream fileInput = new FileInputStream(inputPath)) {
            int readByte = fileInput.read();

            while (readByte >= 0) {
                if (!punctuation.contains((char) readByte)) {
                    output.write(readByte);
                }
                readByte = fileInput.read();
            }
        } catch (IOException exception) {

            throw new RuntimeException(exception);
        }
        output.close();
    }
}
