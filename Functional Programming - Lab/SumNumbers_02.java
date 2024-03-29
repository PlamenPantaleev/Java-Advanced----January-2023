package JavaAdvancedLab.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = s -> Integer.parseInt(s);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> parse.apply(elem)).collect(Collectors.toList());

        int sum = numbers.stream().mapToInt(a -> a).sum();

        System.out.printf("Count = %d%n", numbers.size());
        System.out.printf("Sum = %d%n", sum);

    }
}
