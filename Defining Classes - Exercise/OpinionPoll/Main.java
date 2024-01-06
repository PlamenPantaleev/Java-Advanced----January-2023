package JavaAdvancedExercise.DefiningClasses.OpinionPoll;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static final Map<String, Integer> dataForPerson = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfPeople; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            dataForPerson.put(person.getName(), person.getAge());
        }
        for (Map.Entry<String, Integer> entry : dataForPerson.entrySet()) {
            if (entry.getValue() > 30) {
                System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
