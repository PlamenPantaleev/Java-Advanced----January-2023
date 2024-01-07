import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {



        String pathToFile = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allRows = Files.readAllLines(Path.of(pathToFile));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        for (String row : allRows) {
            writer.write(row.toUpperCase());
            writer.newLine();
        }
        writer.close();


    }
}
