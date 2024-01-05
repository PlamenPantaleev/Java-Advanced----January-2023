package JavaAdvancedLab.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).filter(num -> num % 2 ==0).collect(Collectors.toList());

        //numbers.removeIf(num -> num % 2 != 0);

        printList(numbers, ", ");
        System.out.println();
        List<Integer> sortedNumber = numbers.stream().sorted().collect(Collectors.toList());
        printList(sortedNumber, ", ");
    }

    private static void printList(List<Integer> numbers, String s) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.print(numbers.get(i) + " ");
            } else {
                System.out.print(numbers.get(i) + s);
            }
        }
    }
}
