package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        TreeSet<String> chemicals = new TreeSet<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String [] currentChemicals = scanner.nextLine().split("\\s+");

            chemicals.addAll(Arrays.asList(currentChemicals));
        }

        while (chemicals.size() != 0) {
            String currentChemical = chemicals.iterator().next();
            System.out.print(currentChemical + " ");
            chemicals.remove(currentChemical);

        }
    }
}
