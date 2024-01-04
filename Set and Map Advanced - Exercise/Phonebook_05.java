package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, String> nameAndPhoneNumber = new LinkedHashMap<>();

        while (!command.equals("search")) {
            String [] dataInput = command.split("-");
            String name = dataInput[0];
            String phoneNumber = dataInput[1];


            nameAndPhoneNumber.put(name, phoneNumber);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("stop")) {
            String currentName = command;

            if (nameAndPhoneNumber.containsKey(currentName)) {
                System.out.printf("%s -> %s%n", currentName, nameAndPhoneNumber.get(currentName));
            } else {
                System.out.printf("Contact %s does not exist.%n", currentName);
            }

            command = scanner.nextLine();
        }
    }
}
