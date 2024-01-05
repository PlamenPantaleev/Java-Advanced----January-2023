package JavaAdvancedExercise.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            Predicate<String> predicate = null;

            String criteria = command.split("\\s+")[2];

            if (command.contains("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);

            } else if (command.contains("StartsWith")) {
                predicate = x -> x.startsWith(criteria);
            } else  {
                predicate = x -> x.endsWith(criteria);
            }

            if (command.contains("Remove")) {
                ArrayList<String> toRemove = new ArrayList<>();
                for (String name : guests) {
                    if (predicate.test(name)) {
                        toRemove.add(name);
                    }
                }
                guests.removeAll(toRemove);
            } else if (command.contains("Double")) {
                ArrayList<String> toAdd = new ArrayList<>();

                for (String name : guests) {
                    if (predicate.test(name)) {
                        toAdd.add(name);
                    }
                }
                guests.addAll(toAdd);
            }
            command = scanner.nextLine();
        }
        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(guests.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
