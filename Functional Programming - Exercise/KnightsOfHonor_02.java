package JavaAdvancedExercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        //Consumer<String> printName = name -> System.out.printf("Sir %s%n", name);
        //names.stream().forEach(name -> printName.accept(name));

        Consumer<List<String>> printNames = list -> {
            for (String name : list) {
                System.out.printf("Sir %s%n", name);
            }
        };
        printNames.accept(names);
    }
}
