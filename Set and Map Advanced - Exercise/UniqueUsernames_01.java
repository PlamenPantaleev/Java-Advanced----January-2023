package JavaAdvancedExercise.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < numberOfInputs; i++) {
            String currentInput = scanner.nextLine();

            usernames.add(currentInput);
        }
        int numberOfLoops = usernames.size();
        for (int i = 0; i < numberOfLoops; i++) {
            String currentUsername = usernames.iterator().next();
            usernames.remove(currentUsername);
            System.out.println(currentUsername);
        }
    }
}
