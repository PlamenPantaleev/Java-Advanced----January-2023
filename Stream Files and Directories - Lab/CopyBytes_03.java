package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.*;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String path = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\Files-and-Streams\\output.txt";

        OutputStream outputStream = new FileOutputStream(outputPath);
        try (InputStream fileInput = new FileInputStream(path)) {
            int oneByte = fileInput.read();


            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }

                oneByte = fileInput.read();
            }
        } catch (IOException exception ) {
           throw new RuntimeException(exception);
        }
        outputStream.close();
    }
}