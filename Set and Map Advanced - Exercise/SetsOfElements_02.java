package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] sizeOfSets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int sizeFirstSet = sizeOfSets[0];
        int sizeSecondSet = sizeOfSets[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeFirstSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < sizeSecondSet; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }
        while (firstSet.size() != 0) {


            int firstNumber = firstSet.iterator().next();

            firstSet.remove(firstNumber);

            if (secondSet.contains(firstNumber)) {
                System.out.print(firstNumber + " ");
            }
            firstSet.remove(firstNumber);
        }
    }
}
