package JavaAdvancedLab.DefeiningClasses.Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Car car = new Car();

        for (int i = 1; i <=  numberOfCars; i++) {
            String [] carInfo = scanner.nextLine().split("\\s+");

            car.setBrand(carInfo[0]);
            car.setModel(carInfo[1]);
            car.setHorsepower(Integer.parseInt(carInfo[2]));

            System.out.println(car.getCarInfo(car.getBrand(), car.getModel(), car.getHorsepower()));
        }



    }
}
