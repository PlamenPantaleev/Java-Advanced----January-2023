package JavaAdvancedLab.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] boundaries = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int startBoundary = boundaries[0];
        int endBoundary = boundaries[1];


        Predicate<Integer> filterCondition =
                command.equals("odd") ?
                        (x -> x % 2 != 0) :
                        (x -> x % 2 == 0);

        List<Integer> numbers = new ArrayList<>();
        fillNumbers(numbers, startBoundary, endBoundary);

        Stream nums = numbers.stream().filter(number -> filterCondition.test(number));
        nums.forEach(number -> System.out.println(number));
    }

    private static void fillNumbers(List<Integer> numbers, int startBoundary, int endBoundary) {
        for (int i = startBoundary; i <= endBoundary; i++) {
            numbers.add(i);
        }
    }
}
