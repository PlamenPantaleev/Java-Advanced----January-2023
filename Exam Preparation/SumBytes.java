import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String filePath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        //List<String> fileRows = Files.readAllLines(Path.of(filePath));

        long totalSum = 0;
        // for (String line : fileRows) {
        //   for (char symbol : line.toCharArray()) {
        //        totalSum += symbol;
        //    }
        // }
        // System.out.println(totalSum);


        byte[] allBytes = Files.readAllBytes(Path.of(filePath));

        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                totalSum += ascii;
            }
        }
        System.out.println(totalSum);
    }
}
