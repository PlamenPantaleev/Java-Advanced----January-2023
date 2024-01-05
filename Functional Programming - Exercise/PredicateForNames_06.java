package JavaAdvancedExercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String [] names = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = name -> name.length() <= length;
        Arrays.stream(names).filter(predicate).forEach(System.out::println);
    }
}
