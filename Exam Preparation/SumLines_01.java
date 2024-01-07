import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        //1.Всички редове от файла input.txt.
        //2.За всеки ред -> сумата от ASCII кодовете.
        //3. Принтиране.

        String pathToFile = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> fileLines = Files.readAllLines(Path.of(pathToFile));

        //начин 1:
        // for (String line : fileLines) {
        //    int sum = 0;
        //   for (char symbol : line.toCharArray()) {
        //      sum += symbol;
        //   }
        //   System.out.println(sum);
        //}

        //начин 2:
        fileLines.stream().map(line -> line.toCharArray())
                .forEach(arr -> {
                    int sum = 0;
                    for (char symbol : arr) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}
