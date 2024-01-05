package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {

        String folderPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(folderPath);
        File [] allFilesInFolder = folder.listFiles();

        int totalBytes = 0;

        if (allFilesInFolder != null) {
            for (File currentFile : allFilesInFolder) {
                totalBytes += currentFile.length();
            }
        }
        System.out.printf("Folder size: %d", totalBytes);
    }
}
