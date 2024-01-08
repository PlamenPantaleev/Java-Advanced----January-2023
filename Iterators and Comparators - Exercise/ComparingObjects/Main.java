package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        int equalPeople = 0;
        int differentPeople = 0;

        Person person;

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] personData = command.split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];
            person = new Person(name, age, town);
            people.add(person);

            command = scanner.nextLine();
        }
        int personForComparisonIndex = Integer.parseInt(scanner.nextLine());
        Person comparablePerson = people.get(personForComparisonIndex - 1);

        for (int i = 0; i < people.size(); i++) {
            int result = comparablePerson.compareTo(people.get(i));

            if (result == 0) {
                equalPeople++;
            } else {
                differentPeople++;
            }
        }
        if (equalPeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(equalPeople + " " + differentPeople + " " + people.size());
        }
    }
}
