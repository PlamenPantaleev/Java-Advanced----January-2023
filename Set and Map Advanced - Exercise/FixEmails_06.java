package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String name = command;
            String email = scanner.nextLine();

            if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
                command = scanner.nextLine();
                continue;
            } else {
                emails.put(name, email);
            }

            command = scanner.nextLine();
        }
        emails.entrySet().forEach(entry -> System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue()));
    }
}
