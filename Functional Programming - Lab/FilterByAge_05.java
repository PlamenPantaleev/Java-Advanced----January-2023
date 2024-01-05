package JavaAdvancedLab.FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> personalInfo = new LinkedHashMap<>();


        for (int i = 1; i <= lines; i++) {
            String[] inputArray = scanner.nextLine().split(", ");
            String name = inputArray[0];
            String age = inputArray[1];

            personalInfo.put(name, Integer.parseInt(age));
        }
        String condition = scanner.nextLine();
        int yearsForCondition = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, yearsForCondition);
        Consumer<Map.Entry<String, Integer>> getPrintCondition = getPrint(printType);

        personalInfo.entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> getPrintCondition.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrint(String printType) {
       switch (printType) {
           case "name":
               return x -> System.out.println(x.getKey());
           case "age":
               return x -> System.out.println(x.getValue());
           case "name age":
           case "age name":
               return x -> System.out.println(x.getKey() + " - " + x.getValue());
       }
         throw new RuntimeException("Bad format!");
    }

    private static Predicate<Integer> getPredicate(String condition, int yearsForCondition) {
        if (condition.equals("younger")) {
            return x -> x <= yearsForCondition;
        } else if (condition.equals("older")) {
            return x -> x >= yearsForCondition;
        }
        throw new RuntimeException("Bad condition! Use 'older' or 'younger'");
    }
}
