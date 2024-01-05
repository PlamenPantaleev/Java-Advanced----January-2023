package JavaAdvancedExercise.FunctionalProgramming;

import java.io.IOError;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrayList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());



        Function<List<Integer>, Integer> smallestNumber = numbers ->
                Collections.min(numbers);
        int smallestNum = smallestNumber.apply(arrayList);
        System.out.println(smallestNum);

    }
}
