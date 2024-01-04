package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, symbols.get(currentSymbol) + 1);
            } else {
                symbols.put(currentSymbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            char currentSymbol = entry.getKey();
            System.out.printf("%s: %d time/s%n", currentSymbol, entry.getValue());
        }
    }
}
