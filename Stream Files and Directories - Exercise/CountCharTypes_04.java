package JavaAdvancedExercise.StreamsFilesAndDirectories;

import java.io.*;

public class CountCharTypes_04 {
    public static void main(String[] args) {

        String inputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "E:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputPath));
             PrintWriter outputWriter = new PrintWriter(new FileWriter(outputPath))) {

            String currentLine = inputReader.readLine();

            int vowels = 0;
            int otherSymbols = 0;
            int punctuations = 0;
            while (currentLine != null) {
                vowels += getVowels(currentLine);
                otherSymbols += getOtherSymbols(currentLine);
                punctuations += getPunctuations(currentLine);
                currentLine = inputReader.readLine();
            }
            outputWriter.printf("Vowels: %d%n", vowels);
            outputWriter.printf("Other symbols: %d%n", otherSymbols);
            outputWriter.printf("Punctuation: %d",  punctuations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getOtherSymbols(String currentLine) {
        int otherSymbols = 0;
        for (int i = 0; i < currentLine.length(); i++) {
            char currentSymbol = currentLine.charAt(i);

            if (currentSymbol != ',' && currentSymbol != '.' &&
                    currentSymbol != '!' && currentSymbol != '?' && currentSymbol != 'a' && currentSymbol != 'e' && currentSymbol != 'o'
                    && currentSymbol != 'i' && currentSymbol != 'u' && currentSymbol != ' ') {
                otherSymbols++;
            }
        }
        return otherSymbols;
    }

    private static int getPunctuations(String currentLine) {
        int punctuation = 0;
        for (int i = 0; i < currentLine.length(); i++) {
            char currentSymbol = currentLine.charAt(i);

            if (currentSymbol == ',' || currentSymbol == '.' ||
                currentSymbol == '!' || currentSymbol == '?') {
                punctuation++;
            }
        }
        return punctuation;
    }

    private static int getVowels(String currentLine) {
        int vowels = 0;
        for (int i = 0; i < currentLine.length(); i++) {
            char currentSymbol = currentLine.charAt(i);

            if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'o'
                    || currentSymbol == 'i' || currentSymbol == 'u') {
                vowels++;
            }
        }
        return vowels;
    }
}
