package JavaAdvancedLab.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        UnaryOperator<Double> VAT = price -> price * 1.2;
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble)
                .collect(Collectors.toList());

        List<Double> pricesWithVAT = new ArrayList<>();

        for (double price : prices) {
            double newPrice = VAT.apply(price);

            pricesWithVAT.add(newPrice);
        }
        System.out.printf("Prices with VAT:%n");

        pricesWithVAT.forEach(price -> System.out.printf("%.2f%n", price));
    }
}
