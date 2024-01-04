package JavaAdvancedLab.SetsAndMapAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!command.equals("END")) {
            String movement = command.split(", ")[0];
            String carID = command.split(", ")[1];

            if (movement.equals("IN")) {
                cars.add(carID);
            } else if (movement.equals("OUT")) {
                cars.remove(carID);
            }

            command = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(System.out::println);
        }
    }
}
