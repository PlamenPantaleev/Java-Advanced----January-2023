package JavaAdvancedLab.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = w -> System.out.println(w);

        List<String> textInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(word -> isUppercase.test(word)).collect(Collectors.toList());

        System.out.println(textInput.size());
        textInput.forEach(elem -> print.accept(elem));



    }
}
