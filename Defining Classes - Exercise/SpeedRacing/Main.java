package JavaAdvancedExercise.DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String [] carInformation = scanner.nextLine().split("\\s+");
            String carModel = carInformation[0];
            double fuelAmount = Double.parseDouble(carInformation[1]);
            double costForOneKM = Double.parseDouble(carInformation[2]);

            Car car = new Car(carModel, fuelAmount, costForOneKM);
            //къде ще съхранявам въведените коли?
            cars.put(carModel, car);

        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            //command : Drive: {Car Model} {Amount of KMs}
            String [] commandArray = command.split("\\s+");
            String carModelToDrive = commandArray[1];
            int amountOfKms = Integer.parseInt(commandArray[2]);

            Car carToDrive = cars.get(carModelToDrive);

            if (!carToDrive.drive(amountOfKms)) {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}
