package JavaAdvancedLab.StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {

        String inputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Streams-Files-and-Directories-ResourcesLab\\06.SortLinesOutput.txt";

        Path path = Paths.get(inputPath);
        List<String> sortedLines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path output = Paths.get(outputPath);
        Files.write(output, sortedLines);
    }
}
