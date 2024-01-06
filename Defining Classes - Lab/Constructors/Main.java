package JavaAdvancedLab.DefeiningClasses.Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=  numberOfCars; i++) {
            String [] carInfo = scanner.nextLine().split("\\s+");

            if (carInfo.length > 1) {
                Car car = new Car(carInfo[0], carInfo[1], Integer.parseInt(carInfo[2]));
                System.out.println(car);
            } else {
                Car car = new Car(carInfo[0]);
                System.out.println(car);
            }

        }



    }
}
