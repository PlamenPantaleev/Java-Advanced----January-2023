package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\input.txt";
        try (FileInputStream fileInput = new FileInputStream(path)) {
            int oneByte = fileInput.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInput.read();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
