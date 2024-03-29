package JavaAdvancedExercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = (number, list) -> {
            for (int num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <=n; i++) {
            if (isDivisible.apply(i, divisors)) {
                System.out.print(i + " ");
            }
        }
    }
}
