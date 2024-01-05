package JavaAdvancedExercise.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int divisor = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        Predicate<Integer> checkDivision = x -> x % divisor == 0;

        numbers.removeIf(checkDivision);
        numbers.forEach(number -> System.out.print(number + " "));
    }
}
