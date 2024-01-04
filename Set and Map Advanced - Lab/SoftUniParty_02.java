package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Set<String> partyGuests = new TreeSet<>();

        while (!command.equals("PARTY")) {
            String currentGuest = command;

            partyGuests.add(currentGuest);

            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("END")){
            String guestName = command;

            if (partyGuests.contains(guestName)) {
                partyGuests.remove(guestName);
            }
            command = scanner.nextLine();

        }
        System.out.println(partyGuests.size());
        partyGuests.forEach(System.out::println);
    }
}
