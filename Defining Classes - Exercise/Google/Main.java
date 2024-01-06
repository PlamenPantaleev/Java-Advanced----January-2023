package JavaAdvancedExercise.DefiningClasses.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String [] personData = command.split("\\s+");
            String personName = personData[0];
            String possibleClass = personData[1];
            if (!people.containsKey(personName)) {
                people.put(personName, new Person());
            }
            if (possibleClass.equals("company")) {
                String companyName = personData[2];
                String department = personData[3];
                double salary = Double.parseDouble(personData[4]);
                people.get(personName).setCompany(new Company(companyName, department, salary));
            } else if (possibleClass.equals("pokemon")) {
                String pokemonName = personData[2];
                String pokemonType = personData[3];
                people.get(personName).getPokemonList().add(new Pokemon(pokemonName, pokemonType));
            } else if (possibleClass.equals("parents")) {
                String parentName = personData[2];
                String parentBirthday = personData[3];
                people.get(personName).getParents().add(new Parents(parentName, parentBirthday));
            } else if (possibleClass.equals("children")) {
                String childName = personData[2];
                String childBirthday = personData[3];
                people.get(personName).getChildren().add(new Children(childName, childBirthday));
            } else if (possibleClass.equals("car")) {
                String carModel = personData[2];
                String carSpeed = personData[3];
                people.get(personName).setCar(new Car(carModel, carSpeed));
            }

            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        System.out.println(command);
        System.out.println(people.get(command));
    }
}
